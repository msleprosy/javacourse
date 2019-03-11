package com.epam.javacourse.country.repository;

import com.epam.javacourse.common.business.repository.BaseRepository;

public interface CountryRepository extends BaseRepository {

    //void add(Country country);

    void deleteByName(String nameForDeleting);

    //List<Country> search(CountrySearchCondition searchCondition);
}
