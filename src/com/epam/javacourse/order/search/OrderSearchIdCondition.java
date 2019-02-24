package com.epam.javacourse.order.search;

import com.epam.javacourse.order.service.OrderMemoryService;
import com.epam.javacourse.util.BaseSearchIdCondition;

public class OrderSearchIdCondition extends BaseSearchIdCondition{

    private OrderMemoryService orderMemoryService = new OrderMemoryService();

    @Override
    public void search(Long id){
    orderMemoryService.findOrderById(id);
    }
}
