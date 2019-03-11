package com.epam.javacourse.user.service;

import com.epam.javacourse.common.business.service.BaseService;
import com.epam.javacourse.user.domain.User;
import com.epam.javacourse.user.search.UserSearchCondition;

import java.util.List;

public interface UserService extends BaseService {
    void evaluateOrderPriceByUserType(double price);

    // void add(User user);

    void deleteByName(String nameForDeleting);

    List<User> search(UserSearchCondition searchCondition);
}
