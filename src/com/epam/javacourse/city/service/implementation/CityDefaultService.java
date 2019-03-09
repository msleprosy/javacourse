package com.epam.javacourse.city.service.implementation;

import com.epam.javacourse.city.domain.City;
import com.epam.javacourse.city.repository.CityRepository;
import com.epam.javacourse.city.service.CityService;

public class CityDefaultService implements CityService {

    private final CityRepository cityRepository;

    public CityDefaultService(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    @Override
    public void addCity(City city) {
        cityRepository.addCity(city);
    }

    @Override
    public void deleteByName(String nameForDeleting) {
        cityRepository.deleteByName(nameForDeleting);
    }

    @Override
    public void update(City city) {
       cityRepository.update(city);
    }

    @Override
    public City findById(long id) {
        return cityRepository.findById(id);
    }

    @Override
    public City findByName(String cityName) {
        return cityRepository.findByName(cityName);
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
