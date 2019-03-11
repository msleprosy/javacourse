package com.epam.javacourse.country.repository;

import com.epam.javacourse.common.business.repository.BaseRepository;
import com.epam.javacourse.country.domain.Country;
import com.epam.javacourse.country.search.CountrySearchCondition;

import java.util.List;

public interface CountryRepository extends BaseRepository {

    //void add(Country country);

    void deleteByName(String nameForDeleting);

    List<Country> search(CountrySearchCondition searchCondition);
}
