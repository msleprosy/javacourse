package com.epam.javacourse.country.repository;

import com.epam.javacourse.country.Country;

import static com.epam.javacourse.memory.Memory.countries;

public class CountryMemoryRepository implements CountryRepository{

    public void addCountry(Country country) {
        countries.add(country);
    }

    public void deleteCountry(Country country) {
        String foundName = findCountryNameByEntity(country);
        if (foundName != null) {
            deleteCountryByName(foundName);
        }
    }

    public void updateCountryName(String currentCountryName, String newCountryName){
        for (Country country : countries) {
            if (country.getName().equals(currentCountryName)) {
                country.setName(newCountryName);
            }
        }
    }

    public void updateCountryLanguage(String countryName, String currentCountryLanguage, String newCountryLanguage){
        for (Country country : countries) {
            if (country.getName().equals(countryName)) {
                if (country.getLanguage().equals(currentCountryLanguage)) {
                    country.setLanguage(newCountryLanguage);
                }
            }
        }
    }

    public void printCountries() {
        for (Country country : countries) {
            System.out.println(country);
        }
    }

    private String findCountryNameByEntity(Country countryEntity) {
        for(Country country : countries) {
            if (country.equals(countryEntity)) {
                return country.getName();
            }
        }
        return null;
    }

    private void deleteCountryByName(String countryName) {
        for (Country country : countries) {
            if (country.getName().equals(countryName)) {
                countries.remove(country);
            }
        }
    }
}
