package com.epam.javacourse.country.service;

import com.epam.javacourse.common.business.service.BaseService;
import com.epam.javacourse.country.domain.Country;
import com.epam.javacourse.country.search.CountrySearchCondition;

import java.util.List;

public interface CountryService extends BaseService {
    //void add(Country country);

    void deleteByName(String nameForDeleting);

    List<Country> search(CountrySearchCondition searchCondition);
}
