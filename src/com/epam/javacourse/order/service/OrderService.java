package com.epam.javacourse.order.service;

import com.epam.javacourse.common.business.service.BaseService;

public interface OrderService extends BaseService {
    void evaluateOrderPriceByUserType(double price);

    //void addOrder(Order order);

}
