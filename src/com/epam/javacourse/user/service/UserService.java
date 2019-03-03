package com.epam.javacourse.user.service;

import com.epam.javacourse.common.business.service.BaseServiceForOperationsWithNameField;
import com.epam.javacourse.user.domain.User;

public interface UserService extends BaseServiceForOperationsWithNameField{
    void evaluateOrderPriceByUserType(double price);
    void addUser(User user);
    User findById(Long id);
}
