package com.epam.javacourse.country.service.implementation;

import com.epam.javacourse.city.repository.CityRepository;
import com.epam.javacourse.common.business.domain.BaseDomain;
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
    public void add(BaseDomain country) {
        countryRepository.add(country);
    }

    @Override
    public void update(BaseDomain type) {

    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String nameForDeleting) {
        countryRepository.deleteByName(nameForDeleting);
    }

   /* @Override
    public Country findById(Long id) {
        return countryRepository.findById(id);
    }

      @Override
    public Country findByName(String countryName) {
        return countryRepository.findByName(countryName);
    }*/

    @Override
    public List<Country> search(CountrySearchCondition searchCondition) {
        return countryRepository.search(searchCondition);
    }

    @Override
    public void printAll() {
        countryRepository.printAll();
    }
}
