package com.epam.javacourse.city.repository;

public interface CityRepository extends BaseRepository {

    //void add(City city);

    void deleteByName(String nameForDeleting);

    //void update(City city);

    //List<City> search(CitySearchCondition searchCondition);
}
