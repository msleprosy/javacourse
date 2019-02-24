package com.epam.javacourse.city.repository;

import com.epam.javacourse.city.City;

public interface CityRepository {

    void addCity(City city);
    void deleteCity(City city);
    void updateCityName(String currentCityName, String newCityName);
    void updateCityPopulation(String cityName, int currentCityPopulation, int newCityPopulation);
    void updateTheCapitalMark(String cityName);
    void printCities();

}
