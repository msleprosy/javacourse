package com.epam.javacourse.common.business.repository;

import com.epam.javacourse.common.business.domain.BaseDomain;

/**
 * Created by veronika on 28.02.2019.
 */
public interface BaseRepository<T extends BaseDomain> {

    void add(T type);

    void update(T type);

    void deleteById(long id);

    void printAll();
}
