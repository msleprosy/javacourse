package com.epam.javacourse.user.service;

import com.epam.javacourse.common.business.service.BaseService;
import com.epam.javacourse.user.domain.User;

public interface UserService extends BaseService {
    void evaluateOrderPriceByUserType(double price);

    void addUser(User user);

    void deleteByName(String nameForDeleting);

    void update(User user);

    User findById(Long id);

    User findByName(String name);
}
