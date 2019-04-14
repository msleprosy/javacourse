package com.epam.javacourse.country.repository;

import com.epam.javacourse.common.solutions.repository.BaseRepository;
import com.epam.javacourse.country.domain.Country;
import com.epam.javacourse.country.search.CountrySearchCondition;

import java.util.List;

public interface CountryRepository extends BaseRepository<Country, Long> {

    List<Country> search(CountrySearchCondition searchCondition);
}
