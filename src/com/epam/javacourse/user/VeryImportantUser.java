package com.epam.javacourse.user;

public class VeryImportantUser extends User {

    private static final int FULL_PERCENTAGE = 100;
    private static final int DISCOUNT_PERCENTAGE = 25;

    public VeryImportantUser(){}

    public VeryImportantUser (Long id, String name, String lastName, int passportNumber) {
        super(id, name, lastName, passportNumber);
    }

    public void setVeryImportantUserDiscount(double price){
        price = price - (price * DISCOUNT_PERCENTAGE / FULL_PERCENTAGE);
    }
}

