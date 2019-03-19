package com.epam.javacourse.order.repository;

import com.epam.javacourse.common.solutions.repository.BaseRepository;
import com.epam.javacourse.order.domain.Order;
import com.epam.javacourse.order.search.OrderSearchCondition;

import java.util.List;

public interface OrderRepository extends BaseRepository<Order, Long> {
    List<Order> search(OrderSearchCondition searchCondition);
}
