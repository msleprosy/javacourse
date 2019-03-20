package com.epam.javacourse.storage.initor;

import com.epam.javacourse.country.domain.Country;
import com.epam.javacourse.country.service.CountryService;
import com.epam.javacourse.storage.initor.datasourcereader.DataSourceIoTxtFileFromResourcesReader;
import com.epam.javacourse.storage.initor.datasourcereader.DataSourceReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by veronika on 20.03.2019.
 */
public class StorageInitor {
    private CountryService countryService;

    public StorageInitor(CountryService countryService) {
        this.countryService = countryService;
    }

    public enum DataSourceType {
        TXT_FILE, XML_FILE, JSON_FILE
    }

    public void initStorageWithCountriesAndCities(String filePath, DataSourceType dataSourceType) throws Exception {
        List<Country> countriesToPersist = getCountriesFromStorage(filePath, dataSourceType);

        if (!countriesToPersist.isEmpty()) {
            for (Country country : countriesToPersist) {
                countryService.add(country);
            }
        }
    }

    private List<Country> getCountriesFromStorage(String filePath, DataSourceType dataSourceType) throws Exception {

        List<Country> countries = new ArrayList<>();
        DataSourceReader<List<Country>> dataSourceReader = null;

        switch (dataSourceType) {

            case TXT_FILE: {
                dataSourceReader = new DataSourceIoTxtFileFromResourcesReader();
                break;
            }
            case XML_FILE: {
                break;
            }
            case JSON_FILE: {
                break;
            }
        }

        if (dataSourceReader != null) {
            countries = dataSourceReader.getDataFromFile(filePath);
        }

        return countries;
    }
}
