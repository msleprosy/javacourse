package com.epam.javacourse.country.service;

import com.epam.javacourse.common.solutions.service.BaseService;
import com.epam.javacourse.country.domain.Country;
import com.epam.javacourse.country.search.CountrySearchCondition;

import java.util.List;

public interface CountryService extends BaseService<Country, Long> {
    List<Country> search(CountrySearchCondition searchCondition);
}
