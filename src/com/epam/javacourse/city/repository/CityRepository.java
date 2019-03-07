package com.epam.javacourse.city.repository;

import com.epam.javacourse.city.domain.City;
import com.epam.javacourse.common.business.repository.BaseRepository;

public interface CityRepository extends BaseRepository {

    void addCity(City city);

    void deleteByName(String nameForDeleting);

    void update(City city);

    City findById(long id);

    City findByName(String cityName);
}
