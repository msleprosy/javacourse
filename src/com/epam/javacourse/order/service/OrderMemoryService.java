package com.epam.javacourse.order.service;

import com.epam.javacourse.order.domain.Order;
import com.epam.javacourse.order.repository.implementation.OrderMemoryCollectionRepository;
import com.epam.javacourse.user.service.UserMemoryService;

public class OrderMemoryService implements OrderService{

    private UserMemoryService userMemoryService = new UserMemoryService();

    private OrderMemoryCollectionRepository orderMemoryCollectionRepository = new OrderMemoryCollectionRepository();

    public void evaluateOrderPriceByUserType(double price){
        userMemoryService.evaluateOrderPriceByUserType(price);
    }

    public void addOrder(Order order) {
        orderMemoryCollectionRepository.addOrder(order);
    }

    public Order findOrderById(Long id) {
        return orderMemoryCollectionRepository.findOrderById(id);
    }

    public void deleteOrder(Order order) {
        orderMemoryCollectionRepository.deleteOrder(order);
    }

    public void deleteOrder(Long id) {
        orderMemoryCollectionRepository.deleteOrder(id);
    }

    public void printOrders(){
        orderMemoryCollectionRepository.printOrders();
    }
}
