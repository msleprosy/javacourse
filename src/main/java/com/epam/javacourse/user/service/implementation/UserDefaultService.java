package com.epam.javacourse.user.service.implementation;

import com.epam.javacourse.user.domain.SimpleUser;
import com.epam.javacourse.user.domain.User;
import com.epam.javacourse.user.domain.VeryImportantUser;
import com.epam.javacourse.user.repository.UserRepository;
import com.epam.javacourse.user.search.UserSearchCondition;
import com.epam.javacourse.user.service.UserService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserDefaultService implements UserService {

    private static final int THRESHOLD_PRICE_OF_THE_ORDER = 10000;

    private SimpleUser simpleUser = new SimpleUser();

    private VeryImportantUser veryImportantUser = new VeryImportantUser();

    private final UserRepository userRepository;

    public UserDefaultService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
    public User add(User user) {
        if (user != null) {
            userRepository.add(user);
        }
        return user;
    }

    @Override
    public void add(Collection<User> users) {
        if (users != null && !users.isEmpty()) {
            userRepository.add(users);
        }
    }

    @Override
    public void update(User user) {

    }

    @Override
    public Optional<User> findById(Long id) {
        if (id != null) {
            return userRepository.findById(id);
        } else {
        return null;
    }
}

    @Override
    public void deleteById(Long id) {
        if (id != null) {
            userRepository.deleteById(id);
        }
    }

    @Override
    public void delete(User user) {
        if (user.getId() != null) {
            this.deleteById(user.getId());
        }
    }

    @Override
    public void printAll() {
        userRepository.printAll();
    }

    @Override
    public List<? extends User> search(UserSearchCondition searchCondition) {
        if (searchCondition.getId() != null) {
            return userRepository.findById(searchCondition.getId()).map(Collections::singletonList).orElse(Collections.emptyList());
        } else {
            return userRepository.search(searchCondition);
        }
    }


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public int countAll() {
        return userRepository.countAll();
    }
}
