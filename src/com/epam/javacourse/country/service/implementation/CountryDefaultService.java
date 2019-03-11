package com.epam.javacourse.country.service.implementation;

import com.epam.javacourse.city.repository.CityRepository;
import com.epam.javacourse.common.business.domain.BaseDomain;
import com.epam.javacourse.common.business.search.BaseSearchCondition;
import com.epam.javacourse.country.repository.CountryRepository;
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

    @Override
    public void printAll() {
        countryRepository.printAll();
    }

    @Override
    public List search(BaseSearchCondition searchCondition) {
        return countryRepository.search(searchCondition);
    }
}
