package com.epam.javacourse.city.repository;

import com.epam.javacourse.city.domain.City;
import com.epam.javacourse.common.business.repository.BaseRepositoryForOperationsWithNameField;

public interface CityRepository extends BaseRepositoryForOperationsWithNameField{

    void addCity(City city);
    void updateCityPopulation(String cityName, int currentCityPopulation, int newCityPopulation);
    void updateTheCapitalMark(String cityName);
    City findById(long id);
    City findByName(String cityName);
}
