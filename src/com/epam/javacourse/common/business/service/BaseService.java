package com.epam.javacourse.common.business.service;

import com.epam.javacourse.common.business.domain.BaseDomain;
import com.epam.javacourse.common.business.search.BaseSearchCondition;

import java.util.List;

/**
 * Created by veronika on 28.02.2019.
 */
public interface BaseService<T extends BaseDomain, C extends BaseSearchCondition> {

    void add(T type);

    void update(T type);

    void deleteById(Long id);

    void printAll();

    List<T> search(C searchCondition);

}
