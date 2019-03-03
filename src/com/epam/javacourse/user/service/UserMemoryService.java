package com.epam.javacourse.user.service;

import com.epam.javacourse.user.domain.SimpleUser;
import com.epam.javacourse.user.domain.User;
import com.epam.javacourse.user.domain.VeryImportantUser;
import com.epam.javacourse.user.repository.implementation.UserMemoryCollectionRepository;

public class UserMemoryService implements UserService{

    private static final int THRESHOLD_PRICE_OF_THE_ORDER = 10000;

    private SimpleUser simpleUser = new SimpleUser();

    private VeryImportantUser veryImportantUser = new VeryImportantUser();

    private UserMemoryCollectionRepository userMemoryCollectionRepository = new UserMemoryCollectionRepository();

    @Override
    public void evaluateOrderPriceByUserType(double price){
        if (price <= THRESHOLD_PRICE_OF_THE_ORDER){
            simpleUser.setSimpleUserDiscount(price);
        } else {
            veryImportantUser.setVeryImportantUserDiscount(price);
        }
    }

    @Override
    public void addUser(User user) {
        userMemoryCollectionRepository.addUser(user);
    }

    @Override
    public User findById(Long id) {
        return userMemoryCollectionRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        userMemoryCollectionRepository.deleteById(id);
    }

    @Override
    public void printAll(){
        userMemoryCollectionRepository.printAll();
    }

    @Override
    public void deleteByName(String nameForDeleting) {
        userMemoryCollectionRepository.deleteByName(nameForDeleting);
    }

    @Override
    public void updateByName(String currentName, String newName) {
        userMemoryCollectionRepository.updateByName(currentName, newName);
    }
}
