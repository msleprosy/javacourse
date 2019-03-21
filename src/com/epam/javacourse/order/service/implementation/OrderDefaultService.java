package com.epam.javacourse.order.service.implementation;

import com.epam.javacourse.order.domain.Order;
import com.epam.javacourse.order.repository.OrderRepository;
import com.epam.javacourse.order.search.OrderSearchCondition;
import com.epam.javacourse.order.service.OrderService;
import com.epam.javacourse.user.service.UserService;

import java.util.Collections;
import java.util.List;

public class OrderDefaultService implements OrderService {

    private final OrderRepository orderRepository;

    private final UserService userService;

    public OrderDefaultService(OrderRepository orderRepository, UserService userService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
    }

    @Override
    public void evaluateOrderPriceByUserType(double price) {
        userService.evaluateOrderPriceByUserType(price);
    }

    @Override
    public void add(Order entity) {
        orderRepository.add(entity);
    }

    @Override
    public void update(Order entity) {

    }

    @Override
    public Order findById(Long id) {
        if (id != null) {
            return orderRepository.findById(id);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        if (id != null) {
            orderRepository.deleteById(id);
        }
    }

    @Override
    public void delete(Order entity) {
        if (entity.getId() != null) {
            this.deleteById(entity.getId());
        }
    }

    @Override
    public List<Order> search(OrderSearchCondition searchCondition) {
        return orderRepository.search(searchCondition);
    }

    public void printAll() {
        orderRepository.printAll();
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrdersByUser(Long userId) {
        if (userId != null) {
            return orderRepository.findByUserId(userId);
        }

        return Collections.emptyList();
    }
}
