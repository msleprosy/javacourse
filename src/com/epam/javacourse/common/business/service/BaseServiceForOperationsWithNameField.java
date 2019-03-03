package com.epam.javacourse.common.business.service;

/**
 * Created by veronika on 03.03.2019.
 */
public interface BaseServiceForOperationsWithNameField extends BaseService {
    void deleteByName(String nameForDeleting);
    void updateByName(String currentName, String newName);
}
