package com.epam.javacourse.city.service.implementation;

import com.epam.javacourse.city.domain.City;
import com.epam.javacourse.city.repository.CityRepository;
import com.epam.javacourse.city.service.CityService;

public class CityDefaultService implements CityService {

    private final CityRepository cityRepository;

    CityDefaultService(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    @Override
    public void addCity(City city) {
        cityRepository.addCity(city);
    }

    @Override
    public void deleteById(long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String cityNameForDeleting) {
        cityRepository.deleteByName(cityNameForDeleting);
    }

    @Override
    public void updateCityName(String currentCityName, String newCityName){
        cityRepository.updateCityName(currentCityName, newCityName);
    }

    @Override
    public void updateCityPopulation(String cityName, int currentCityPopulation, int newCityPopulation){
        cityRepository.updateCityPopulation(cityName, currentCityPopulation, newCityPopulation);
    }

    @Override
    public void updateTheCapitalMark(String cityName){
        cityRepository.updateTheCapitalMark(cityName);
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
