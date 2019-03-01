package com.epam.javacourse.order.repository.implementation;

import com.epam.javacourse.order.domain.Order;
import com.epam.javacourse.order.repository.OrderRepository;

import static com.epam.javacourse.memory.Memory.orders;

public class OrderMemoryCollectionRepository implements OrderRepository {

    @Override
    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public void deleteOrder(long id) {
        Long foundIndex = findOrderIndexById(id);
        if (foundIndex != null) {
            deleteOrderByIndex(foundIndex);
        }
    }

    @Override
    public Order findById(long id) {
        return findOrderById(id);
    }

    @Override
    public void deleteById(long id) {
        Order found = findOrderById(id);
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

    private Order findOrderById(long orderId) {
        for (Order order : orders) {
            if (Long.valueOf(orderId).equals(order.getId())) {
                return order;
            }
        }
        return null;
    }

    private void deleteOrderByIndex(long orderIndex){
        for (Order order : orders){
            if (order.getId().equals(orderIndex)){
             orders.remove(order);
            }
        }
    }

    private Long findOrderIndexById(long id) {
        for (Order order : orders) {
            if (order.getId().equals(id)) {
                return order.getId();
            }
        }
        return null;
    }

}
