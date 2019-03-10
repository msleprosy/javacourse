package com.epam.javacourse.user.domain;

import com.epam.javacourse.common.business.domain.BaseDomain;
import com.epam.javacourse.order.domain.Order;

import java.util.List;

public class User extends BaseDomain {
    private String name;
    private String lastName;
    private String passportNumber;
    private List<Order> orders;

    public User() {
    }

    public User(String name, String lastName, String passportNumber) {
        this.name = name;
        this.lastName = lastName;
        this.passportNumber = passportNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getUserAsStr() {
        return "id = " + id +
                ", name = '" + name + '\'' +
                ", lastName = '" + lastName + '\'';

    }

    @Override
    public String toString() {
        return "User{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", passportNumber = " + passportNumber +
                '}';
    }

}
