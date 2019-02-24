package com.epam.javacourse.city.repository;

import com.epam.javacourse.city.City;

/**
 * Created by veronika on 24.02.2019.
 */
public interface CityRepository {

    void addCity(City city);
    void deleteCity(City city);
    void updateCityName(String currentCityName, String newCityName);
    void updateCityPopulation(String cityName, int currentCityPopulation, int newCityPopulation);
    void updateTheCapitalMark(String cityName);
    void printCities();

}
