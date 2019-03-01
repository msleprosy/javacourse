package com.epam.javacourse.user.service;

import com.epam.javacourse.user.domain.User;

public interface UserService {
    void evaluateOrderPriceByUserType(double price);
    void addUser(User user);
    User findUserById(Long id);
    void deleteUser(User user);
    void deleteUser(Long id);
    void printUsers();
}
