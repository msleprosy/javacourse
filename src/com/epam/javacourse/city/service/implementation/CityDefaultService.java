package com.epam.javacourse.city.service.implementation;

import com.epam.javacourse.city.domain.City;
import com.epam.javacourse.city.repository.CityRepository;
import com.epam.javacourse.city.search.CitySearchCondition;
import com.epam.javacourse.city.service.CityService;

import java.util.Collection;
import java.util.List;

public class CityDefaultService implements CityService {

    private final CityRepository cityRepository;

    public CityDefaultService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void add(City entity) {
        if (entity != null) {
            cityRepository.add(entity);
        }
    }

    @Override
    public void add(Collection<City> cities) {
        if (cities != null && !cities.isEmpty()) {
            cityRepository.add(cities);
        }
    }

    @Override
    public void update(City entity) {

    }

    @Override
    public City findById(Long id) {
        if (id != null) {
            return cityRepository.findById(id);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        if (id != null) {
            cityRepository.deleteById(id);
        }
    }

    @Override
    public void delete(City entity) {
        if (entity.getId() != null) {
            this.deleteById(entity.getId());
        }
    }

    @Override
    public void printAll() {
        cityRepository.printAll();
    }

    @Override
    public List<City> search(CitySearchCondition searchCondition) {
        return cityRepository.search(searchCondition);
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public int countAll() {
        return cityRepository.countAll();
    }
}
