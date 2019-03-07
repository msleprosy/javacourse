package com.epam.javacourse.country.repository;

import com.epam.javacourse.common.business.repository.BaseRepository;
import com.epam.javacourse.country.domain.Country;
import com.epam.javacourse.country.search.CountrySearchCondition;

import java.util.List;

public interface CountryRepository extends BaseRepository {

    void addCountry(Country country);

    void deleteByName(String nameForDeleting);

    void update(Country country);

    Country findById(Long id);

    Country findByName(String countryName);

    List<Country> search(CountrySearchCondition searchCondition);
}
