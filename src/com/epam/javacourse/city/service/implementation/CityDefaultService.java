package com.epam.javacourse.city.service.implementation;

import com.epam.javacourse.city.repository.CityRepository;
import com.epam.javacourse.city.service.CityService;
import com.epam.javacourse.common.business.domain.BaseDomain;
import com.epam.javacourse.common.business.search.BaseSearchCondition;

import java.util.List;

public class CityDefaultService implements CityService {

    private final CityRepository cityRepository;

    public CityDefaultService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
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

    @Override
    public List search(BaseSearchCondition searchCondition) {
        return cityRepository.search(searchCondition);
    }
}
