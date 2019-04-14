package com.epam.javacourse.order.search;

import com.epam.javacourse.city.domain.City;
import com.epam.javacourse.common.business.search.BaseSearchCondition;
import com.epam.javacourse.country.domain.Country;
import com.epam.javacourse.user.domain.User;

public class OrderSearchCondition extends BaseSearchCondition {
    private double price;
    private User user;
    private Country country;
    private City city;
    private OrderByField orderByField;

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

    public OrderByField getOrderByField() {
        return orderByField;
    }

    public void setOrderByField(OrderByField orderByField) {
        this.orderByField = orderByField;
    }

    public boolean needOrdering() {
        return super.needOrdering() && orderByField != null;
    }
}
