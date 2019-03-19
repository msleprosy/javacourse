package com.epam.javacourse.city.service;

import com.epam.javacourse.city.domain.City;
import com.epam.javacourse.city.search.CitySearchCondition;
import com.epam.javacourse.common.solutions.service.BaseService;

import java.util.List;

public interface CityService extends BaseService<City, Long> {

    List<City> search(CitySearchCondition searchCondition);
}
