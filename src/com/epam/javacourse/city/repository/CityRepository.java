package com.epam.javacourse.city.repository;

import com.epam.javacourse.city.domain.City;
import com.epam.javacourse.city.search.CitySearchCondition;
import com.epam.javacourse.common.solutions.repository.BaseRepository;

import java.util.List;

public interface CityRepository extends BaseRepository<City, Long> {
    List<? extends City> search(CitySearchCondition searchCondition);
}
