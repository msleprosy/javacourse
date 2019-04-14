package com.epam.javacourse.common.solutions.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by veronika on 19.03.2019.
 */
public interface BaseService<TYPE, ID> {

    TYPE add(TYPE entity);

    void add(Collection<TYPE> items);

    void update(TYPE entity);

    Optional<TYPE> findById(ID id);

    void deleteById(ID id);

    void delete(TYPE entity);

    void printAll();

    List<TYPE> findAll();

    int countAll();

}