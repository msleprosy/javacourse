package com.epam.javacourse.order.repository.implementation;

import com.epam.javacourse.memory.SequenceGenerator;
import com.epam.javacourse.order.domain.Order;
import com.epam.javacourse.order.repository.OrderRepository;

import static com.epam.javacourse.memory.Memory.orders;

public class OrderMemoryCollectionRepository implements OrderRepository {

    @Override
    public void addOrder(Order order) {
        order.setId(SequenceGenerator.getNextValue());
        orders.add(order);
    }

    @Override
    public void deleteById(long id) {
        Order found = findOrderById(id);
        if (found != null) {
            orders.remove(found);
        }
    }

    @Override
    public Order findById(Long id) {
        return findOrderById(id);
    }

    @Override
    public void printAll() {
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    private Order findOrderById(long orderId) {
        for (Order order : orders) {
            if (Long.valueOf(orderId).equals(order.getId())) {
                return order;
            }
        }
        return null;
    }
}
