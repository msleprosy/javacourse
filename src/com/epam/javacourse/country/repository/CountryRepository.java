package com.epam.javacourse.country.repository;

import com.epam.javacourse.common.business.repository.BaseRepository;
import com.epam.javacourse.country.domain.Country;

public interface CountryRepository extends BaseRepository{

    void addCountry(Country country);
    void deleteById(long id);
    void deleteByName(String countryNameForDeleting);
    void updateCountryName(String currentCountryName, String newCountryName);
    void updateCountryLanguage(String countryName, String currentCountryLanguage, String newCountryLanguage);
    Country findById(long id);
}
