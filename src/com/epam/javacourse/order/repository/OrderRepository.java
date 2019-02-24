package com.epam.javacourse.order.repository;

import com.epam.javacourse.order.Order;

public interface OrderRepository {
    void addOrder(Order order);
    void deleteOrder(Order order);
    void deleteOrder(Long id);
    void printOrders();
}
