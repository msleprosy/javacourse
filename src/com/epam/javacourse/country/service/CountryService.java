package com.epam.javacourse.country.service;

import com.epam.javacourse.common.business.service.BaseServiceForOperationsWithNameField;
import com.epam.javacourse.country.domain.Country;

public interface CountryService extends BaseServiceForOperationsWithNameField{
    void addCountry(Country country);
    void updateCountryLanguage(String countryName, String currentCountryLanguage, String newCountryLanguage);
    Country findById(Long id);
    Country findByName(String countryName);
}
