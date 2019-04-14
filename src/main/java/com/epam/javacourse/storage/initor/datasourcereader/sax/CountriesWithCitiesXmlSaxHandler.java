package com.epam.javacourse.storage.initor.datasourcereader.sax;

import com.epam.javacourse.city.domain.City;
import com.epam.javacourse.country.domain.Country;
import com.epam.javacourse.country.domain.CountryDiscriminator;
import com.epam.javacourse.country.domain.CountryWithColdClimate;
import com.epam.javacourse.country.domain.CountryWithHotClimate;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

import static com.epam.javacourse.common.solutions.utils.CollectionUtils.getLast;

/**
 * Created by veronika on 25.03.2019.
 */

public class CountriesWithCitiesXmlSaxHandler extends DefaultHandler {

    private StringBuilder stringBuilder = new StringBuilder();
    private List<Country> countries;
    private List<City> cities;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        stringBuilder.setLength(0);

        switch (qName) {
            case "countries": {
                countries = new ArrayList<>();
                break;
            }

            case "country": {
                if (isCountryWithColdClimate(attributes)) {
                    countries.add(new CountryWithColdClimate());
                } else {
                    countries.add(new CountryWithHotClimate());
                }
                break;
            }

            case "cities": {
                cities = new ArrayList<>();
                getLast(countries).setCities(cities);
                break;
            }

            case "city": {
                cities.add(new City());
                break;
            }
        }
    }

    private boolean isCountryWithColdClimate(Attributes attributes) {
        return CountryDiscriminator.COLD_CLIMATE.equals(CountryDiscriminator.valueOf(attributes.getValue("type")));
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String data = stringBuilder.toString();

        switch (qName) {

            case "polarNight": {
                getCountryWithColdClimate().setWithPolarNight(Boolean.parseBoolean(data));
                break;
            }

            case "hottestMonth": {
                getCountryWithHotClimate().setHottestMonth(data);
                break;
            }
            case "averageTemperature": {
                getCountryWithHotClimate().setAverageTemperature(data);
                break;
            }

            case "name": {
                getLast(countries).setName(data);
                break;
            }

            case "language": {
                getLast(countries).setLanguage(data);
                break;
            }

            case "nameCity": {
                getLast(cities).setName(data);
                break;
            }
            case "population": {
                getLast(cities).setPopulation(Integer.parseInt(data));
                break;
            }
            case "capital": {
                getLast(cities).setIsCapital(Boolean.parseBoolean(data));
                break;
            }
        }
    }

    private CountryWithHotClimate getCountryWithHotClimate() {
        return (CountryWithHotClimate) getLast(countries);
    }

    private CountryWithColdClimate getCountryWithColdClimate() {
        return (CountryWithColdClimate) getLast(countries);
    }

    public List<Country> getCountries() {
        return countries;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        stringBuilder.append(value.replaceAll("\\n", ""));
    }

}
