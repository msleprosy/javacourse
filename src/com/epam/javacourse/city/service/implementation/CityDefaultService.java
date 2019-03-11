package com.epam.javacourse.city.service.implementation;

import com.epam.javacourse.city.domain.City;
import com.epam.javacourse.city.repository.CityRepository;
import com.epam.javacourse.city.search.CitySearchCondition;
import com.epam.javacourse.city.service.CityService;
import com.epam.javacourse.common.business.domain.BaseDomain;

import java.util.List;

public class CityDefaultService implements CityService {

    private final CityRepository cityRepository;

    public CityDefaultService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> search(CitySearchCondition searchCondition) {
        return cityRepository.search(searchCondition);
    }

    @Override
    public void deleteByName(String nameForDeleting) {
        cityRepository.deleteByName(nameForDeleting);
    }

    @Override
    public void add(BaseDomain city) {
        cityRepository.add(city);
    }

    @Override
    public void update(BaseDomain type) {
    }

    @Override
    public void deleteById(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public void printAll() {
        cityRepository.printAll();
    }
}
