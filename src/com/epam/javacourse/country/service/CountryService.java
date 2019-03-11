package com.epam.javacourse.country.service;

import com.epam.javacourse.common.business.service.BaseService;

public interface CountryService extends BaseService {
    //void add(Country country);

    void deleteByName(String nameForDeleting);

    //List<Country> search(CountrySearchCondition searchCondition);
}
