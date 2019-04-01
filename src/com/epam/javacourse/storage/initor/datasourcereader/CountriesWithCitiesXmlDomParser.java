package com.epam.javacourse.storage.initor.datasourcereader;

/**
 * Created by veronika on 25.03.2019.
 */

import com.epam.javacourse.city.domain.City;
import com.epam.javacourse.country.domain.Country;
import com.epam.javacourse.country.domain.CountryDiscriminator;
import com.epam.javacourse.country.domain.CountryWithColdClimate;
import com.epam.javacourse.country.domain.CountryWithHotClimate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.epam.javacourse.common.solutions.xml.dom.XmlDomUtils.getOnlyElementTextContent;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

public class CountriesWithCitiesXmlDomParser implements XmlParser<List<Country>> {

    @Override
    public List<Country> parseFile(String file) throws Exception {
        if (!new File(file).exists() || new File(file).isDirectory()) {
            throw new Exception("No such file");
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document doc = documentBuilder.parse(new File(file));

        Element root = (Element) doc.getElementsByTagName("countries").item(0);

        NodeList xmlCountries = root.getElementsByTagName("country");
        List<Country> result = new ArrayList<>();

        for (int i = 0; i < xmlCountries.getLength(); i++) {
            result.add(getCountryFromXmlElement((Element) xmlCountries.item(i)));
        }
        return result;
    }


    private Country getCountryFromXmlElement(Element xmlCountry) {

        String type = xmlCountry.getAttribute("type");

        Country country = null;
        switch (CountryDiscriminator.valueOf(type)) {

            case COLD_CLIMATE: {
                country = new CountryWithColdClimate();
                CountryWithColdClimate coldClimate = (CountryWithColdClimate) country;
                coldClimate.setWithPolarNight(parseBoolean(getOnlyElementTextContent(xmlCountry, "polarNight")));
                break;
            }
            case HOT_CLIMATE: {
                country = new CountryWithHotClimate();
                CountryWithHotClimate hotClimate = (CountryWithHotClimate) country;
                hotClimate.setHottestMonth(getOnlyElementTextContent(xmlCountry, "hottestMonth"));
                hotClimate.setAverageTemperature(getOnlyElementTextContent(xmlCountry, "averageTemperature"));
                break;
            }
        }

        country.setName(getOnlyElementTextContent(xmlCountry, "name"));
        country.setLanguage(getOnlyElementTextContent(xmlCountry, "language"));

        NodeList cities = xmlCountry.getElementsByTagName("city");
        if (cities.getLength() > 0) {
            country.setCities(new ArrayList<>());

            for (int i = 0; i < cities.getLength(); i++) {
                City city = getCityFromXmlElement(cities.item(i));
                country.getCities().add(city);
            }
        }

        return country;
    }

    private City getCityFromXmlElement(Node xmlCity) {

        City city = new City();

        city.setName(getOnlyElementTextContent((Element) xmlCity, "nameCity"));
        city.setPopulation(parseInt(getOnlyElementTextContent((Element) xmlCity, "population")));
        city.setIsCapital(parseBoolean(getOnlyElementTextContent((Element) xmlCity, "capital")));

        return city;
    }
}