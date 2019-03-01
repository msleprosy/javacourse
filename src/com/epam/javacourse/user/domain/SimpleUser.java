package com.epam.javacourse.user.domain;

public class SimpleUser extends User {

    private static final int FULL_PERCENTAGE = 100;
    private static final int DISCOUNT_PERCENTAGE = 5;

    public SimpleUser(){}

    public SimpleUser (Long id, String name, String lastName, int passportNumber) {
        super(id, name, lastName, passportNumber);
    }

    public void setSimpleUserDiscount(double price) {
            price = price - (price * DISCOUNT_PERCENTAGE / FULL_PERCENTAGE);
    }
}


