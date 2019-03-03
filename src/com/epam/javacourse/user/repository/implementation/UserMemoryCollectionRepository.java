package com.epam.javacourse.user.repository.implementation;

import com.epam.javacourse.user.domain.User;
import com.epam.javacourse.user.repository.UserRepository;

import java.util.Iterator;

import static com.epam.javacourse.memory.Memory.users;

public class UserMemoryCollectionRepository implements UserRepository {

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public User findById(long id) {
        return findUserById(id);
    }

    @Override
    public void deleteByName(String nameForDeleting) {
        deleteUserByName(nameForDeleting);
    }

    @Override
    public void updateByName(String currentName, String newName) {
        for (User user : users) {
            if (user.getName().equals(currentName)) {
                user.setName(newName);
            }
        }
    }

    @Override
    public User findByName(String name) {
        for (User user : users) {
            if (name.equals(user.getName())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void deleteById(long id) {
        User found = findUserById(id);
        if (found != null) {
            users.remove(found);;
        }
    }

    @Override
    public void printAll() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    private User findUserById(long userId) {
        for (User user : users) {
            if (Long.valueOf(userId).equals(user.getId())) {
                return user;
            }
        }
        return null;
    }

    private void deleteUserByName(String nameForDeleting) {
        Iterator<User> iter = users.iterator();
        while (iter.hasNext()) {
            String userName = iter.next().getName();
            if (userName.equals(nameForDeleting)) {
                iter.remove();
            }
        }
    }
}

