package com.epam.javacourse.user.service;

import com.epam.javacourse.common.business.service.BaseService;

public interface UserService extends BaseService {
    void evaluateOrderPriceByUserType(double price);

    // void add(User user);

    void deleteByName(String nameForDeleting);

    // List<User> search(UserSearchCondition searchCondition);
}
