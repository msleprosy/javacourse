package com.epam.javacourse.common.solutions.service;

/**
 * Created by veronika on 19.03.2019.
 */
public interface BaseService<TYPE, ID> {

    void add(TYPE entity);

    void update(TYPE entity);

    TYPE findById(ID id);

    void deleteById(ID id);

    void delete(TYPE entity);

    void printAll();

}