package com.epam.javacourse.user.service.implementation;

import com.epam.javacourse.common.business.domain.BaseDomain;
import com.epam.javacourse.common.business.search.BaseSearchCondition;
import com.epam.javacourse.user.domain.SimpleUser;
import com.epam.javacourse.user.domain.VeryImportantUser;
import com.epam.javacourse.user.repository.UserRepository;
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
    public void evaluateOrderPriceByUserType(double price) {
        if (price <= THRESHOLD_PRICE_OF_THE_ORDER) {
            simpleUser.setSimpleUserDiscount(price);
        } else {
            veryImportantUser.setVeryImportantUserDiscount(price);
        }
    }

    @Override
    public void deleteByName(String nameForDeleting) {
        userRepository.deleteByName(nameForDeleting);
    }

    @Override
    public void add(BaseDomain user) {
        userRepository.add(user);
    }

    @Override
    public void update(BaseDomain type) {
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void printAll() {
        userRepository.printAll();
    }

    @Override
    public List search(BaseSearchCondition searchCondition) {
        {
            return userRepository.search(searchCondition);
        }
    }
}
