package com.epam.javacourse.storage.initor;

import com.epam.javacourse.country.domain.Country;
import com.epam.javacourse.country.service.CountryService;
import com.epam.javacourse.storage.initor.datasourcereader.CountriesWithCitiesXmlDomParser;
import com.epam.javacourse.storage.initor.datasourcereader.CountriesWithCitiesXmlStaxParser;
import com.epam.javacourse.storage.initor.datasourcereader.XmlParser;
import com.epam.javacourse.storage.initor.datasourcereader.sax.CountriesWithCitiesXmlSaxParser;

import java.util.List;

//import com.epam.javacourse.storage.initor.datasourcereader.CountriesWithCitiesTxtFileParser;



public class StorageInitializer {
    private CountryService countryService;

    public StorageInitializer(CountryService countryService) {
        this.countryService = countryService;
    }

    public enum DataSourceType {
        TXT_FILE, XML_FILE
    }

    public void initStorageWithCountriesAndCities(String filePath, DataSourceType dataSourceType) throws Exception {

        List<Country> countryList = getCountriesFromStorage(filePath, dataSourceType);

        if (!countryList.isEmpty()) {
            for (Country country : countryList) {
                countryService.add(country);
            }
        }
    }

    private List<Country> getCountriesFromStorage(String filePath, DataSourceType dataSourceType) throws Exception {

        XmlParser<List<Country>> dataSourceReader = null;

        switch (dataSourceType) {

            case XML_FILE: {
                dataSourceReader = new CountriesWithCitiesXmlDomParser();
                dataSourceReader = new CountriesWithCitiesXmlSaxParser();
                dataSourceReader = new CountriesWithCitiesXmlStaxParser();

                break;
            }
        }

        return dataSourceReader.parseFile(filePath);
    }
}
