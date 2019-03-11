package com.epam.javacourse.common.business.service;

import com.epam.javacourse.common.business.domain.BaseDomain;

/**
 * Created by veronika on 28.02.2019.
 */
public interface BaseService<T extends BaseDomain> {

    void add(T type);

    void update(T type);

    void deleteById(Long id);

    void printAll();

}
