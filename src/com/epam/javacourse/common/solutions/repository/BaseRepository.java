package com.epam.javacourse.common.solutions.repository;

/**
 * Created by veronika on 19.03.2019.
 */
    public interface BaseRepository<TYPE, ID> {

        void add(TYPE entity);

        void update(TYPE entity);

        TYPE findById(ID id);

        void deleteById(ID id);

        void printAll();
    }