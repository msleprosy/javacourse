package com.epam.javacourse.user.service.implementation;

import com.epam.javacourse.user.domain.SimpleUser;
import com.epam.javacourse.user.domain.User;
import com.epam.javacourse.user.domain.VeryImportantUser;
import com.epam.javacourse.user.repository.UserRepository;
import com.epam.javacourse.user.search.UserSearchCondition;
import com.epam.javacourse.user.service.UserService;

import java.util.List;

public class UserDefaultService implements UserService {

    private static final int THRESHOLD_PRICE_OF_THE_ORDER = 10000;

    private SimpleUser simpleUser = new SimpleUser();

    private VeryImportantUser veryImportantUser = new VeryImportantUser();

    private final UserRepository userRepository;

    public UserDefaultService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> search(UserSearchCondition searchCondition) {
        return userRepository.search(searchCondition);
    }

    @Override
    public void evaluateOrderPriceByUserType(double price) {
        if (price <= THRESHOLD_PRICE_OF_THE_ORDER) {
            simpleUser.setSimpleUserDiscount(price);
        } else {
            veryImportantUser.setVeryImportantUserDiscount(price);
        }
    }

    @Override
    public void addUser(User user) {
        userRepository.addUser(user);
    }

    @Override
    public void deleteByName(String nameForDeleting) {
        userRepository.deleteByName(nameForDeleting);
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }


    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public void printAll() {
        userRepository.printAll();
    }


}
