package com.epam.javacourse.order.repository;

import com.epam.javacourse.common.business.repository.BaseRepository;
import com.epam.javacourse.order.domain.Order;

public interface OrderRepository extends BaseRepository{
    void addOrder(Order order);
    Order findById(Long id);
}
