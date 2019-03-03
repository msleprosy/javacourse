package com.epam.javacourse.city.service;

import com.epam.javacourse.city.domain.City;
import com.epam.javacourse.common.business.service.BaseServiceForOperationsWithNameField;

public interface CityService extends BaseServiceForOperationsWithNameField{
    void addCity(City city);
    void updateCityPopulation(String cityName, int currentCityPopulation, int newCityPopulation);
    void updateTheCapitalMark(String cityName);
    City findById(long id);
    City findByName(String cityName);
}
