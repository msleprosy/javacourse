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
    public void add(User entity) {
        userRepository.add(entity);
    }

    @Override
    public void add(Collection<User> users) {
        if (users != null && !users.isEmpty()) {
            userRepository.add(users);
        }
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public User findById(Long id) {
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
    public void delete(User entity) {
        if (entity.getId() != null) {
            this.deleteById(entity.getId());
        }
    }

    @Override
    public void printAll() {
        userRepository.printAll();
    }

    @Override
    public List<? extends User> search(UserSearchCondition searchCondition) {
        if (searchCondition.getId() != null) {
            return Collections.singletonList(userRepository.findById(searchCondition.getId()));
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
