package com.epam.javacourse.country.repository.implementation;

import com.epam.javacourse.country.domain.Country;
import com.epam.javacourse.country.repository.CountryRepository;
import com.epam.javacourse.country.search.CountrySearchCondition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static com.epam.javacourse.common.solutions.utils.StringUtils.isNotBlank;
import static com.epam.javacourse.memory.Memory.countries;

public class CountryMemoryCollectionRepository implements CountryRepository {
    @Override
    public void addCountry(Country country) {
        countries.add(country);
    }

    @Override
    public void updateByName(String currentName, String newName){
        for (Country country : countries) {
            if (country.getName().equals(currentName)) {
                country.setName(newName);
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
    public Country findById(Long id) {
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
    public List<Country> search(CountrySearchCondition searchCondition) {
            if (searchCondition.getId() != null) {
                return Collections.singletonList(findById(searchCondition.getId()));
            } else {
                boolean searchByName = isNotBlank(searchCondition.getName());

                List<Country> result = new ArrayList<>();

                for (Country country : countries) {
                    if (country != null) {
                        boolean found = true;

                        if (searchByName) {
                            found = searchCondition.getName().equals(country.getName());
                        }

                        if (found) {
                            result.add(country);
                        }
                    }
                }

                return result;
            }
        }

    @Override
    public void deleteById(long id) {
        Country found = findCountryById(id);
        if (found != null) {
            countries.remove(found);
        }
    }

    @Override
    public void deleteByName(String nameForDeleting){
         deleteCountryByName(nameForDeleting);
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

    private void deleteCountryByName(String nameForDeleting) {
        Iterator<Country> iter = countries.iterator();
        while (iter.hasNext()) {
            String countryName = iter.next().getName();
            if (countryName.equals(nameForDeleting)) {
                iter.remove();
            }
        }
    }
}
