package com.epam.javacourse.city.service;

import com.epam.javacourse.city.domain.City;
import com.epam.javacourse.city.search.CitySearchCondition;
import com.epam.javacourse.common.business.service.BaseService;

import java.util.List;

public interface CityService extends BaseService {
    void addCity(City city);

    void deleteByName(String nameForDeleting);

    void update(City city);

    City findById(long id);

    City findByName(String cityName);

    List<City> search(CitySearchCondition searchCondition);
}
