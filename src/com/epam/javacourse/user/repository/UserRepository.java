package com.epam.javacourse.user.repository;

import com.epam.javacourse.common.business.repository.BaseRepositoryForOperationsWithNameField;
import com.epam.javacourse.user.domain.User;

public interface UserRepository extends BaseRepositoryForOperationsWithNameField{
    void addUser(User user);
    User findById(long id);
    User findByName(String name);
}
