package com.epam.javacourse.city.service;

import com.epam.javacourse.city.domain.City;
import com.epam.javacourse.common.business.service.BaseService;

public interface CityService extends BaseService {
    void addCity(City city);

    void deleteByName(String nameForDeleting);

    void update(City city);

    City findById(long id);

    City findByName(String cityName);
}
