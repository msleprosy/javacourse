package com.epam.javacourse.user.service;


import com.epam.javacourse.common.solutions.service.BaseService;
import com.epam.javacourse.user.domain.User;
import com.epam.javacourse.user.search.UserSearchCondition;

import java.util.List;

public interface UserService extends BaseService<User, Long> {
    void evaluateOrderPriceByUserType(double price);

    List<? extends User> search(UserSearchCondition searchCondition);
}
