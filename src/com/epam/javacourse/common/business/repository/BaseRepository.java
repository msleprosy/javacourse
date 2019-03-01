package com.epam.javacourse.common.business.repository;

/**
 * Created by veronika on 28.02.2019.
 */
public interface BaseRepository {

    void deleteById(long id);

    void printAll();
}
