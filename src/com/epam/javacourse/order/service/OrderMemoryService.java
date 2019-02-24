package com.epam.javacourse.order.service;

import com.epam.javacourse.order.Order;
import com.epam.javacourse.order.repository.OrderMemoryRepository;
import com.epam.javacourse.user.service.UserMemoryService;

public class OrderMemoryService implements OrderService{

    private UserMemoryService userMemoryService = new UserMemoryService();

    private OrderMemoryRepository orderMemoryRepository = new OrderMemoryRepository();

    public void evaluateOrderPriceByUserType(double price){
        userMemoryService.evaluateOrderPriceByUserType(price);
    }

    public void addOrder(Order order) {
        orderMemoryRepository.addOrder(order);
    }

    public Order findOrderById(Long id) {
        return orderMemoryRepository.findOrderById(id);
    }

    public void deleteOrder(Order order) {
        orderMemoryRepository.deleteOrder(order);
    }

    public void deleteOrder(Long id) {
        orderMemoryRepository.deleteOrder(id);
    }

    public void printOrders(){
        orderMemoryRepository.printOrders();
    }
}
