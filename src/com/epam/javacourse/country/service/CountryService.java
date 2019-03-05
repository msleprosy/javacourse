package com.epam.javacourse.country.service;

import com.epam.javacourse.common.business.service.BaseServiceForOperationsWithNameField;
import com.epam.javacourse.country.domain.Country;
import com.epam.javacourse.country.search.CountrySearchCondition;

import java.util.List;

public interface CountryService extends BaseServiceForOperationsWithNameField{
    void addCountry(Country country);
    void updateCountryLanguage(String countryName, String currentCountryLanguage, String newCountryLanguage);
    Country findById(Long id);
    Country findByName(String countryName);
    List<Country> search(CountrySearchCondition searchCondition);
}
