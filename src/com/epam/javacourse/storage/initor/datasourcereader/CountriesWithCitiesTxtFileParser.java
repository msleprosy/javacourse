package com.epam.javacourse.storage.initor.datasourcereader;

import com.epam.javacourse.country.domain.Country;
import com.epam.javacourse.country.domain.CountryDiscriminator;
import com.epam.javacourse.country.domain.CountryWithColdClimate;
import com.epam.javacourse.country.domain.CountryWithHotClimate;
import com.epam.javacourse.storage.initor.exception.checked.InvalidCountryDiscriminatorException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.epam.javacourse.storage.initor.exception.InitDataExceptionMeta.PARSE_COUNTRY_DISCRIMINATOR_ERROR;

/**
 * Created by veronika on 20.03.2019.
 */
public class CountriesWithCitiesTxtFileParser implements FileParser<List<Country>> {

    private static final String COUNTRY_PLACEHOLDER = "Country:";

    @Override
    public List<Country> parseFile(String file) throws Exception {
        List<String> fileAsList = readFileToList(file);

        List<Country> result = new ArrayList<>();
        if (!fileAsList.isEmpty()) {
            List<List<String>> countriesWithCities = splitFileToSeparateCountriesWithCities(fileAsList);

            for (List<String> countryWithCities : countriesWithCities) {
                result.add(parseCountry(countryWithCities));
            }
        }

        return result;
    }

    private List<String> readFileToList(String file) throws IOException {
        List<String> fileAsList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileAsList.add(line);
            }
        }

        return fileAsList;
    }

    private List<List<String>> splitFileToSeparateCountriesWithCities(List<String> fileAsList) {
        List<List<String>> countriesWithCities = new ArrayList<>();

        List<String> singleCountryWithCities = null;
        for (String dataFromFile : fileAsList) {
            if (!dataFromFile.isEmpty()) {

                //check if country begin
                if (dataFromFile.contains(COUNTRY_PLACEHOLDER)) {
                    if (singleCountryWithCities != null && !singleCountryWithCities.isEmpty()) {
                        countriesWithCities.add(singleCountryWithCities);
                    }
                    singleCountryWithCities = new ArrayList<>();
                    singleCountryWithCities.add(dataFromFile);
                } else if (singleCountryWithCities != null) {
                    singleCountryWithCities.add(dataFromFile);
                }

            }
        }

        return countriesWithCities;
    }

    private Country parseCountry(List<String> countryWithCities) throws InvalidCountryDiscriminatorException {
        String countryAsStr = countryWithCities.get(0).replaceAll(COUNTRY_PLACEHOLDER, "");
        countryWithCities.remove(0);

        String[] cityCsv = countryWithCities.toArray(new String[0]);
        return getCountry(countryAsStr, cityCsv);
    }
//---------------------------------------------------------------------------------------------------------------
    private Country getCountry(String countryCsv, String[] citiesCsv) throws InvalidCountryDiscriminatorException {
        String[] attrs = countryCsv.split("\\|");
        int attrIndex = -1;

        //mark.setModels(new ArrayList<>());
        String discriminatorAsStr = attrs[++attrIndex].trim();
        Country country = createCountryByDiscriminator(discriminatorAsStr);

        for (int i = 0; i < attrs.length; i++) {

            //String discriminatorAsStr = attrs[++attrIndex].trim();
            //Country country = createCountryByDiscriminator(discriminatorAsStr);
            country.setName(attrs[++attrIndex].trim());
            country.setLanguage(attrs[++attrIndex].trim());
            country.setCities(new ArrayList<>());


            if (CountryWithColdClimate.class.equals(country.getClass())) {
                appendColdClimateAttributes((CountryWithColdClimate) country, attrs, attrIndex);
            } else if (CountryWithHotClimate.class.equals(country.getClass())) {
                appendHotClimateAttributes((CountryWithHotClimate) country, attrs, attrIndex);
            }

            //country.getCities().add(city);
        }

        return country;
    }
        /*String discriminatorAsStr = attrs[++attrIndex].trim();
        Country country = createCountryByDiscriminator(discriminatorAsStr);
        country.setCities(new ArrayList<>());
        for (int i = 0; i < citiesCsv.length; i++) {
            String csvCity = citiesCsv[i];
            attrIndex = -1;
            attrs = csvCity.split("\\|");
            City city = new City();
            city.setName(attrs[++attrIndex].trim());
            city.setPopulation(Integer.parseInt(attrs[++attrIndex].trim()));
            city.setIsCapital(Boolean.parseBoolean(attrs[++attrIndex].trim()));
            if (CountryWithColdClimate.class.equals(country.getClass())) {
                appendColdClimateAttributes((CountryWithColdClimate) country, attrs, attrIndex);
            } else if (CountryWithHotClimate.class.equals(country.getClass())) {
                appendHotClimateAttributes((CountryWithHotClimate) country, attrs, attrIndex);
            }
            country.getCities().add(city);
        }
        return country;
    }
*/
//---------------------------------------------------------------------------------------------------------------

    private Country createCountryByDiscriminator(String discriminatorAsStr) throws InvalidCountryDiscriminatorException {
        if (CountryDiscriminator.isDiscriminatorNotExists(discriminatorAsStr)) {
            throw new InvalidCountryDiscriminatorException(
                    PARSE_COUNTRY_DISCRIMINATOR_ERROR.getCode(),
                    PARSE_COUNTRY_DISCRIMINATOR_ERROR.getDescriptionAsFormatStr(discriminatorAsStr)
            );
        } else {
            CountryDiscriminator discriminator = CountryDiscriminator.getDiscriminatorByName(discriminatorAsStr);
            if (CountryDiscriminator.COLD_CLIMATE.equals(discriminator)) {
                return new CountryWithColdClimate();
            }
            return new CountryWithHotClimate();
        }
    }

    private void appendColdClimateAttributes(CountryWithColdClimate country, String[] attrs, int attrIndex) {
        country.setWithPolarNight(Boolean.parseBoolean(attrs[++attrIndex].trim()));
        country.setPhoneCode(attrs[++attrIndex].trim());
    }

    private void appendHotClimateAttributes(CountryWithHotClimate country, String[] attrs, int attrIndex) {
        country.setAverageTemperature(attrs[++attrIndex].trim());
        country.setHottestMonth(attrs[++attrIndex].trim());
    }
}

