package com.epam.javacourse.user.domain;

public class VeryImportantUser extends User {

    private static final int FULL_PERCENTAGE = 100;
    private static final int DISCOUNT_PERCENTAGE = 25;

    public VeryImportantUser(){}

    public VeryImportantUser (String name, String lastName, String passportNumber) {
        super(name, lastName, passportNumber);
    }

    public void setVeryImportantUserDiscount(double price){
        price = price - (price * DISCOUNT_PERCENTAGE / FULL_PERCENTAGE);
    }
}

