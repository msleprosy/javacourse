package com.epam.javacourse.country.repository;

import com.epam.javacourse.common.business.repository.BaseRepositoryForOperationsWithNameField;
import com.epam.javacourse.country.domain.Country;

public interface CountryRepository extends BaseRepositoryForOperationsWithNameField{

    void addCountry(Country country);
    void updateCountryLanguage(String countryName, String currentCountryLanguage, String newCountryLanguage);
    Country findById(Long id);
    Country findByName(String countryName);
}
