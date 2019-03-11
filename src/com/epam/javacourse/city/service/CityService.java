package com.epam.javacourse.city.service;

import com.epam.javacourse.city.domain.City;
import com.epam.javacourse.city.search.CitySearchCondition;
import com.epam.javacourse.common.business.service.BaseService;

import java.util.List;

public interface CityService extends BaseService {
    //void add(City city);

    void deleteByName(String nameForDeleting);

    List<City> search(CitySearchCondition searchCondition);
}
