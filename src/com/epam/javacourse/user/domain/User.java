package com.epam.javacourse.user.domain;

import com.epam.javacourse.common.business.domain.BaseDomain;
import com.epam.javacourse.order.domain.Order;

import java.util.List;

public class User extends BaseDomain {
    private String name;
    private String lastName;
    private int passportNumber;
    private List<Order> orders;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, String lastName, int passportNumber) {
        this.name = name;
        this.lastName = lastName;
        this.passportNumber = passportNumber;
    }

    public User(Long id, String name, String lastName, int passportNumber) {
        this.id = id;
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

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
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
