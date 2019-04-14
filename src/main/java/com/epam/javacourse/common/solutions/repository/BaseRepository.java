package com.epam.javacourse.common.solutions.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by veronika on 19.03.2019.
 */
public interface BaseRepository<TYPE, ID> {

    TYPE add(TYPE entity);

    void add(Collection<TYPE> items);

    void update(TYPE entity);

    Optional<TYPE> findById(ID id);

    void deleteById(ID id);

    void printAll();

    List<TYPE> findAll();

    int countAll();
}
