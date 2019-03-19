package com.epam.javacourse.country.service.implementation;

import com.epam.javacourse.city.domain.City;
import com.epam.javacourse.city.repository.CityRepository;
import com.epam.javacourse.country.domain.Country;
import com.epam.javacourse.country.repository.CountryRepository;
import com.epam.javacourse.country.search.CountrySearchCondition;
import com.epam.javacourse.country.service.CountryService;

import java.util.List;

public class CountryDefaultService implements CountryService {
    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;

    public CountryDefaultService(CountryRepository countryRepository, CityRepository cityRepository) {
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public void add(Country entity) {
        countryRepository.add(entity);

        if (entity.getCities() != null) {
            for (City city : entity.getCities()) {
                if (city != null) {
                    cityRepository.add(city);
                }
            }
        }
    }

    @Override
    public void update(Country entity) {

    }

    @Override
    public Country findById(Long id) {
        if (id != null) {
            return countryRepository.findById(id);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        if (id != null) {
            countryRepository.deleteById(id);
        }
    }

    @Override
    public void delete(Country entity) {
        if (entity.getId() != null) {
            this.deleteById(entity.getId());
        }
    }

    @Override
    public void printAll() {
        countryRepository.printAll();
    }

    @Override
    public List<Country> search(CountrySearchCondition searchCondition) {
        return countryRepository.search(searchCondition);
    }
}
