package com.epam.javacourse.order.service.implementation;

import com.epam.javacourse.common.business.domain.BaseDomain;
import com.epam.javacourse.common.business.search.BaseSearchCondition;
import com.epam.javacourse.order.repository.OrderRepository;
import com.epam.javacourse.order.service.OrderService;
import com.epam.javacourse.user.service.UserService;

import java.util.List;

public class OrderDefaultService implements OrderService {

    private final OrderRepository orderRepository;

    private final UserService userService;

    public OrderDefaultService(OrderRepository orderRepository, UserService userService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
    }

    public void evaluateOrderPriceByUserType(double price) {
        userService.evaluateOrderPriceByUserType(price);
    }

    @Override
    public void add(BaseDomain order) {
        orderRepository.add(order);
    }

    @Override
    public void update(BaseDomain type) {

    }

    @Override
    public void deleteById(Long id) {

    }

    public void printAll() {
        orderRepository.printAll();
    }

    @Override
    public List search(BaseSearchCondition searchCondition) {
        return orderRepository.search(searchCondition);
    }
}
