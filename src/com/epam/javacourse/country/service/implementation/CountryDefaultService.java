package com.epam.javacourse.country.service.implementation;

import com.epam.javacourse.country.domain.Country;
import com.epam.javacourse.country.repository.CountryRepository;
import com.epam.javacourse.country.service.CountryService;

public class CountryDefaultService implements CountryService {

    private final CountryRepository countryRepository;

    CountryDefaultService(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    @Override
    public void addCountry(Country country) {
        countryRepository.addCountry(country);
    }

    @Override
    public void deleteById(long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String countryNameForDeleting) {
        countryRepository.deleteByName(countryNameForDeleting);
    }

    @Override
    public void updateCountryName(String currentCountryName, String newCountryName){
        countryRepository.updateCountryName(currentCountryName, newCountryName);
    }

    @Override
    public void updateCountryLanguage(String countryName, String currentCountryLanguage, String newCountryLanguage){
        countryRepository.updateCountryLanguage(countryName, currentCountryLanguage, newCountryLanguage);
    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);

    }

    @Override
    public void printAll() {
        countryRepository.printAll();
    }
}
