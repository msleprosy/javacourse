package com.epam.javacourse.city.service;

import com.epam.javacourse.city.domain.City;
import com.epam.javacourse.common.business.service.BaseService;

public interface CityService extends BaseService{
    void addCity(City city);
    void deleteById(long id);
    void deleteByName(String cityNameForDeleting);
    void updateCityName(String currentCityName, String newCityName);
    void updateCityPopulation(String cityName, int currentCityPopulation, int newCityPopulation);
    void updateTheCapitalMark(String cityName);
    City findById(long id);
    City findByName(String cityName);
}
