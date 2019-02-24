package com.epam.javacourse.country.service;

import com.epam.javacourse.country.Country;

public interface CountryService {
    void addCountry(Country country);
    void deleteCountry(Country country);
    void updateCountryName(String currentCountryName, String newCountryName);
    void updateCountryLanguage(String countryName, String currentCountryLanguage, String newCountryLanguage);
    void printCountries();
}
