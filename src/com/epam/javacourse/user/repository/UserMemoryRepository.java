package com.epam.javacourse.user.repository;

import com.epam.javacourse.user.User;

import static com.epam.javacourse.memory.Memory.users;

public class UserMemoryRepository implements UserRepository{

    public void addUser(User user) {
        users.add(user);
    }

    public User findUserById(long id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public void deleteUser(User user) {
        Long foundIndex = findUserIndexByEntity(user);

        if (foundIndex != null) {
            deleteUserByIndex(foundIndex);
        }
    }

    public void deleteUser(Long id) {
        Long userIndex = findUserIndexById(id);

        if (userIndex != null) {
            deleteUserByIndex(userIndex);
        }
    }

    public void printUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    private void deleteUserByIndex(Long userIndex) {
        for (User user : users) {
            if (user.getId().equals(userIndex)) {
                users.remove(user);
            }
        }
    }

    private Long findUserIndexByEntity(User userEntity) {
        for (User user : users) {
            if (user.equals(userEntity)) {
                return user.getId();
            }
        }
        return null;
    }

    private Long findUserIndexById(Long userId) {
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user.getId();
            }
        }
        return null;
    }
}

