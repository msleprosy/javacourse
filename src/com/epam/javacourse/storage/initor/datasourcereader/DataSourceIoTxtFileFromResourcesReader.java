package com.epam.javacourse.storage.initor.datasourcereader;

import com.epam.javacourse.city.domain.City;
import com.epam.javacourse.country.domain.Country;
import com.epam.javacourse.storage.initor.exception.checked.InvalidCityDiscriminatorException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.epam.javacourse.storage.initor.exception.InitDataExceptionMeta.PARSE_CITY_DISCRIMINATOR_ERROR;

/**
 * Created by veronika on 20.03.2019.
 */
public class DataSourceIoTxtFileFromResourcesReader implements DataSourceReader<List<Country>> {

    private static final String COUNTRY_PLACEHOLDER = "Country:";

    @Override
    public List<Country> getDataFromFile(String file) throws Exception {
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

    private Country parseCountry(List<String> countryWithCities) throws InvalidCityDiscriminatorException {
        String countryAsStr = countryWithCities.get(0).replaceAll(COUNTRY_PLACEHOLDER, "");
        countryWithCities.remove(0);

        String[] cityCsv = countryWithCities.toArray(new String[0]);
        return getCountry(countryAsStr, cityCsv);
    }

    private Country getCountry(String countryCsv, String[] citiesCsv) throws InvalidCityDiscriminatorException {
        String[] attrs = countryCsv.split("\\|");
        int attrIndex = -1;

        Country country = new Country(attrs[++attrIndex].trim(), attrs[++attrIndex].trim());
        country.setCities(new ArrayList<>());

        for (int i = 0; i < citiesCsv.length; i++) {
            String csvCity = citiesCsv[i];
            attrIndex = -1;
            attrs = csvCity.split("\\|");

            String discriminatorAsStr = attrs[++attrIndex].trim();
            City city = createCityByDiscriminator(discriminatorAsStr);
            city.setName(attrs[++attrIndex].trim());
            city.setDescription(attrs[++attrIndex].trim());
            city.setProductionYearStart(Integer.parseInt(attrs[++attrIndex].trim()));
            int productionYearEnd = Integer.parseInt(attrs[++attrIndex].trim());
            city.setProductionYearEnd(productionYearEnd == -1 ? null : productionYearEnd);

            if (PassengerModel.class.equals(city.getClass())) {
                appendPassengerAttributes((PassengerModel) city, attrs, attrIndex);
            } else if (TruckModel.class.equals(city.getClass())) {
                appendTruckAttributes((TruckModel) city, attrs, attrIndex);
            }

            country.getCities().add(city);
        }

        return country;
    }

    private City createCityByDiscriminator(String discriminatorAsStr) throws InvalidCityDiscriminatorException {
        if (CityDiscriminator.isDiscriminatorNotExists(discriminatorAsStr)) {
            throw new InvalidCityDiscriminatorException(
                    PARSE_CITY_DISCRIMINATOR_ERROR.getCode(),
                    PARSE_CITY_DISCRIMINATOR_ERROR.getDescriptionAsFormatStr(discriminatorAsStr)
            );
        } else {
            CityDiscriminator discriminator = CityDiscriminator.getDiscriminatorByName(discriminatorAsStr);
            if (CityDiscriminator.TRUCK.equals(discriminator)) {
                return new TruckModel();
            }
            return new PassengerModel();
        }
    }

    private void appendPassengerAttributes(PassengerModel model, String[] attrs, int attrIndex) {
        model.setNumberOfAirbags(Integer.parseInt(attrs[++attrIndex].trim()));
        model.setNumberOfSeats(Integer.parseInt(attrs[++attrIndex].trim()));
        model.setAudioSystemName(attrs[++attrIndex].trim());
    }

    private void appendTruckAttributes(TruckModel model, String[] attrs, int attrIndex) {
        model.setWeight(Integer.parseInt(attrs[++attrIndex].trim()));
        model.setEmbeddedKitchen("Y".equals(attrs[++attrIndex].trim()));
        model.setTankSize(Integer.parseInt(attrs[++attrIndex].trim()));
    }
}

