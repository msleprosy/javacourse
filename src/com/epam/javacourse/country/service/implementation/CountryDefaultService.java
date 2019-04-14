package com.epam.javacourse.country.service.implementation;

import com.epam.javacourse.city.domain.City;
import com.epam.javacourse.city.repository.CityRepository;
import com.epam.javacourse.city.service.CityService;
import com.epam.javacourse.country.domain.Country;
import com.epam.javacourse.country.repository.CountryRepository;
import com.epam.javacourse.country.search.CountrySearchCondition;
import com.epam.javacourse.country.service.CountryService;

import java.util.Collection;
import java.util.List;

public class CountryDefaultService implements CountryService {
    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;
    private final CityService cityService;

    public CountryDefaultService(CountryRepository countryRepository, CityRepository cityRepository, CityService cityService) {
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
        this.cityService = cityService;
    }

    @Override
    public void add(Country country) {
        if (country != null) {
        countryRepository.add(country);

        if (country.getCities() != null && !country.getCities().isEmpty()) {
            for (City city : country.getCities()) {
                    cityRepository.add(city);
                }
            }
        }
    }

    @Override
    public void add(Collection<Country> countries) {
        if (countries != null && !countries.isEmpty()) {
            for (Country country : countries) {
                countryRepository.add(country);

                if (country.getCities() != null && !country.getCities().isEmpty()) {
                    cityService.add(country.getCities());
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

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public int countAll() {
        return countryRepository.countAll();
    }
}
