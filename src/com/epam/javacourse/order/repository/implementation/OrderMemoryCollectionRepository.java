package com.epam.javacourse.order.repository.implementation;

import com.epam.javacourse.common.business.domain.BaseDomain;
import com.epam.javacourse.memory.SequenceGenerator;
import com.epam.javacourse.order.domain.Order;
import com.epam.javacourse.order.repository.OrderRepository;

import static com.epam.javacourse.memory.Memory.orders;

public class OrderMemoryCollectionRepository implements OrderRepository {

    @Override
    public void add(BaseDomain order) {
        order.setId(SequenceGenerator.getNextValue());
        orders.add((Order)order);
    }

    @Override
    public void update(BaseDomain type) {

    }

    @Override
    public void deleteById(long id) {
        Order found = findById(id);
        if (found != null) {
            orders.remove(found);
        }
    }

    @Override
    public void printAll() {
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    private Order findById(long orderId) {
        for (Order order : orders) {
            if (Long.valueOf(orderId).equals(order.getId())) {
                return order;
            }
        }
        return null;
    }
}
