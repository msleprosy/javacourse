package com.epam.javacourse.common.business.repository;

import com.epam.javacourse.common.business.domain.BaseDomain;
import com.epam.javacourse.common.business.search.BaseSearchCondition;

import java.util.List;

/**
 * Created by veronika on 28.02.2019.
 */
public interface BaseRepository<T extends BaseDomain, C extends BaseSearchCondition> {

    void add(T type);

    void update(T type);

    void deleteById(long id);

    void printAll();

    List<T> search(C searchCondition);
}
