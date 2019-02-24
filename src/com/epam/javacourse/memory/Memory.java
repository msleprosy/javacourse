package com.epam.javacourse.memory;

import com.epam.javacourse.city.City;
import com.epam.javacourse.country.Country;
import com.epam.javacourse.order.Order;
import com.epam.javacourse.user.User;

import java.util.ArrayList;
import java.util.List;

public class Memory {
    public static List<User> users = new ArrayList<>();
    public static List<Order> orders = new ArrayList<>();
    public static List<Country> countries = new ArrayList<>();
    public static List<City> cities = new ArrayList<>();
}
