package com.epam.javacourse.country.repository.implementation;

import com.epam.javacourse.country.domain.Country;
import com.epam.javacourse.country.repository.CountryRepository;

import java.util.Iterator;

import static com.epam.javacourse.memory.Memory.countries;

public class CountryMemoryCollectionRepository implements CountryRepository {

    @Override
    public void addCountry(Country country) {
        countries.add(country);
    }

    @Override
    public void updateCountryName(String currentCountryName, String newCountryName){
        for (Country country : countries) {
            if (country.getName().equals(currentCountryName)) {
                country.setName(newCountryName);
            }
        }
    }

    @Override
    public void updateCountryLanguage(String countryName, String currentCountryLanguage, String newCountryLanguage){
        for (Country country : countries) {
            if (country.getName().equals(countryName)) {
                if (country.getLanguage().equals(currentCountryLanguage)) {
                    country.setLanguage(newCountryLanguage);
                }
            }
        }
    }

    @Override
    public Country findById(long id) {
        return findCountryById(id);
    }

    @Override
    public Country findByName(String countryName) {
        for (Country country : countries) {
            if (countryName.equals(country.getName())) {
                return country;
            }
        }
        return null;
    }

    @Override
    public void deleteById(long id) {
        Country found = findCountryById(id);
        if (found != null) {
            countries.remove(found);
        }
    }

    @Override
    public void deleteByName(String countryNameForDeleting){
         deleteCountryByName(countryNameForDeleting);
    }

    @Override
    public void printAll() {
        for (Country country : countries) {
            System.out.println(country);
        }
    }

    private Country findCountryById(long countryId) {
        for (Country country : countries) {
            if (Long.valueOf(countryId).equals(country.getId())) {
                return country;
            }
        }
        return null;
    }

    private void deleteCountryByName(String countryNameForDeleting) {
        Iterator<Country> iter = countries.iterator();
        while (iter.hasNext()) {
            String countryName = iter.next().getName();
            if (countryName.equals(countryNameForDeleting)) {
                iter.remove();
            }
        }
    }
}
