package com.epam.javacourse.common.solutions.repository;

import java.util.Collection;
import java.util.List;

/**
 * Created by veronika on 19.03.2019.
 */
public interface BaseRepository<TYPE, ID> {

    void add(TYPE entity);

    void add(Collection<TYPE> items);

    void update(TYPE entity);

    TYPE findById(ID id);

    void deleteById(ID id);

    void printAll();

    List<TYPE> findAll();

    int countAll();
}
