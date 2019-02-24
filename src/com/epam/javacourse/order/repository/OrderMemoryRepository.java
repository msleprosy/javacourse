package com.epam.javacourse.order.repository;

import com.epam.javacourse.order.Order;

import static com.epam.javacourse.memory.Memory.orders;

public class OrderMemoryRepository implements OrderRepository{

    public void addOrder(Order order) {
        orders.add(order);
    }

    public Order findOrderById(Long id) {
        for (Order order : orders) {
            if (order.getId().equals(id)) {
                return order;
            }
        }
        return null;
    }

    public void deleteOrder(Order order) {
        Long foundIndex = findOrderIndexByEntity(order);
        if (foundIndex != null) {
            deleteOrderByIndex(foundIndex);
        }
    }

    public void deleteOrder(Long id) {
        Long foundIndex = findOrderIndexById(id);
        if (foundIndex != null) {
            deleteOrderByIndex(foundIndex);
        }
    }

    public void printOrders() {
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    private void deleteOrderByIndex(Long orderIndex){
        for (Order order : orders){
            if (order.getId().equals(orderIndex)){
             orders.remove(order);
            }
        }
    }

    private Long findOrderIndexById(Long id) {
        for (Order order : orders) {
            if (order.getId().equals(id)) {
                return order.getId();
            }
        }
        return null;
    }


    private Long findOrderIndexByEntity(Order orderEntity){
        for (Order order : orders){
            if (order.equals(orderEntity)){
                return order.getId();
            }
        }
        return null;
    }
}
