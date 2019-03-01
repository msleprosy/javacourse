package com.epam.javacourse.user.service;

import com.epam.javacourse.user.domain.SimpleUser;
import com.epam.javacourse.user.domain.User;
import com.epam.javacourse.user.domain.VeryImportantUser;
import com.epam.javacourse.user.repository.UserMemoryRepository;

public class UserMemoryService implements UserService{

    private static final int THRESHOLD_PRICE_OF_THE_ORDER = 10000;

    private SimpleUser simpleUser = new SimpleUser();

    private VeryImportantUser veryImportantUser = new VeryImportantUser();

    private UserMemoryRepository userMemoryRepository = new UserMemoryRepository();

    public void evaluateOrderPriceByUserType(double price){
        if (price <= THRESHOLD_PRICE_OF_THE_ORDER){
            simpleUser.setSimpleUserDiscount(price);
        } else {
            veryImportantUser.setVeryImportantUserDiscount(price);
        }
    }

    public void addUser(User user) {
        userMemoryRepository.addUser(user);
    }

    public User findUserById(Long id) {
        return userMemoryRepository.findUserById(id);
    }

    public void deleteUser(User user) {
        userMemoryRepository.deleteUser(user);
    }

    public void deleteUser(Long id) {
        userMemoryRepository.deleteUser(id);
    }

    public void printUsers(){
        userMemoryRepository.printUsers();
    }
}
