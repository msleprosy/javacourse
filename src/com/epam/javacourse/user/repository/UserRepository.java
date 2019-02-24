package com.epam.javacourse.user.repository;

import com.epam.javacourse.user.User;

public interface UserRepository {
    void addUser(User user);
    User findUserById(long id);
    void deleteUser(User user);
    void deleteUser(Long id);
    void printUsers();
}
