package com.epam.javacourse.user;

import com.epam.javacourse.order.Order;

import java.util.List;

public class User {
    private Long id;
    private String name;
    private String lastName;
    private int passportNumber;
    private List<Order> orders;

    public User(){}

    public User(String name){
        this.name = name;
    }

    public User(Long id, String name, String lastName, int passportNumber) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.passportNumber = passportNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passportNumber=" + passportNumber +
                '}';
    }

}
