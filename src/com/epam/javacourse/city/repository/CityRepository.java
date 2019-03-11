package com.epam.javacourse.city.repository;

import com.epam.javacourse.common.business.repository.BaseRepository;

public interface CityRepository extends BaseRepository {

    //void add(City city);

    void deleteByName(String nameForDeleting);

    //void update(City city);

    //List<City> search(CitySearchCondition searchCondition);
}
