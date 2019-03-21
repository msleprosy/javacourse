package com.epam.javacourse.order.service;


import com.epam.javacourse.common.solutions.service.BaseService;
import com.epam.javacourse.order.domain.Order;
import com.epam.javacourse.order.search.OrderSearchCondition;

import java.util.List;

public interface OrderService extends BaseService<Order, Long> {
    void evaluateOrderPriceByUserType(double price);

    List<Order> search(OrderSearchCondition searchCondition);

    List<Order> getOrdersByUser(Long userId);

}
