package com.epam.javacourse.city.service;

import com.epam.javacourse.city.City;
import com.epam.javacourse.city.repository.CityMemoryRepository;

public class CityMemoryService implements CityService {

    private CityMemoryRepository cityRepository = new CityMemoryRepository();

    public void addCity(City city) {
        cityRepository.addCity(city);
    }

    public void deleteCity(City city) {
        cityRepository.deleteCity(city);
    }

    public void updateCityName(String currentCityName, String newCityName){
        cityRepository.updateCityName(currentCityName, newCityName);
    }

    public void updateCityPopulation(String cityName, int currentCityPopulation, int newCityPopulation){
        cityRepository.updateCityPopulation(cityName, currentCityPopulation, newCityPopulation);
    }

    public void updateTheCapitalMark(String cityName){
        cityRepository.updateTheCapitalMark(cityName);
    }

    public void printCities(){
        cityRepository.printCities();
    }
}
