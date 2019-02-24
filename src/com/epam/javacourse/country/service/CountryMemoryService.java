package com.epam.javacourse.country.service;

import com.epam.javacourse.country.Country;
import com.epam.javacourse.country.repository.CountryMemoryRepository;

public class CountryMemoryService implements CountryService{

    private CountryMemoryRepository countryRepository = new CountryMemoryRepository();

    public void addCountry(Country country) {
        countryRepository.addCountry(country);
    }

    public void deleteCountry(Country country) {
        countryRepository.deleteCountry(country);
    }

    public void updateCountryName(String currentCountryName, String newCountryName){
        countryRepository.updateCountryName(currentCountryName, newCountryName);
    }

    public void updateCountryLanguage(String countryName, String currentCountryLanguage, String newCountryLanguage){
        countryRepository.updateCountryLanguage(countryName, currentCountryLanguage, newCountryLanguage);
    }

    public void printCountries(){
        countryRepository.printCountries();
    }
}
