package com.epam.javacourse.city.service;

import com.epam.javacourse.common.business.service.BaseService;

public interface CityService extends BaseService {
    //void add(City city);

    void deleteByName(String nameForDeleting);

    //List<City> search(CitySearchCondition searchCondition);
}
