package com.epam.javacourse.memory;

import com.epam.javacourse.city.domain.City;
import com.epam.javacourse.country.domain.Country;
import com.epam.javacourse.order.domain.Order;
import com.epam.javacourse.user.domain.User;

import java.util.ArrayList;
import java.util.List;

public class Memory {
    public static List<User> users = new ArrayList<>();
    public static List<Order> orders = new ArrayList<>();
    public static List<Country> countries = new ArrayList<>();
    public static List<City> cities = new ArrayList<>();
}
