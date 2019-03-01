package com.epam.javacourse.order.service.implementation;

import com.epam.javacourse.order.domain.Order;
import com.epam.javacourse.order.repository.OrderRepository;
import com.epam.javacourse.order.service.OrderService;
import com.epam.javacourse.user.service.UserService;

public class OrderDefaultService implements OrderService {

    private final OrderRepository orderRepository;

    private final UserService userService;

    public OrderDefaultService(OrderRepository orderRepository, UserService userService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
    }

    public void evaluateOrderPriceByUserType(double price){
        userService.evaluateOrderPriceByUserType(price);
    }

    public void addOrder(Order order) {
        orderRepository.addOrder(order);
    }

    public Order findById(Long id) {
        return orderRepository.findById(id);
    }

    public void printAll(){
        orderRepository.printAll();
    }
}
