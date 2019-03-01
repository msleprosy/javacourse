package com.epam.javacourse.country.service;

import com.epam.javacourse.common.business.service.BaseService;
import com.epam.javacourse.country.domain.Country;

public interface CountryService extends BaseService{
    void addCountry(Country country);
    void deleteById(long id);
    void deleteByName(String countryNameForDeleting);
    void updateCountryName(String currentCountryName, String newCountryName);
    void updateCountryLanguage(String countryName, String currentCountryLanguage, String newCountryLanguage);
}
