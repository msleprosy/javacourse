package com.epam.javacourse.common.business.repository;

/**
 * Created by veronika on 03.03.2019.
 */
public interface BaseRepositoryForOperationsWithNameField extends BaseRepository {
    void deleteByName(String nameForDeleting);
    void updateByName(String currentName, String newName);
}
