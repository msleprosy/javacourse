package com.epam.javacourse.order.service;

import com.epam.javacourse.order.Order;

public interface OrderService {
    void evaluateOrderPriceByUserType(double price);
    void addOrder(Order order);
    Order findOrderById(Long id);
    void deleteOrder(Order order);
    void deleteOrder(Long id);
    void printOrders();
}
