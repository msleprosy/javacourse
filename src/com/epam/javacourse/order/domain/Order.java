package com.epam.javacourse.order.domain;

import com.epam.javacourse.city.domain.City;
import com.epam.javacourse.common.business.domain.BaseDomain;
import com.epam.javacourse.country.domain.Country;
import com.epam.javacourse.user.User;

public class Order extends BaseDomain{
    private double price;
    private User user;
    private Country country;
    private City city;

    public Order() {}

    public Long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id = " + id +
                ", price = " + price +
                ", user = " + user +
                ", country = " + country +
                ", city = " + city +
                '}';
    }
}
