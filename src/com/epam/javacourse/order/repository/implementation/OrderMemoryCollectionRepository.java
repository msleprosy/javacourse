package com.epam.javacourse.order.repository.implementation;

import com.epam.javacourse.storage.SequenceGenerator;
import com.epam.javacourse.order.domain.Order;
import com.epam.javacourse.order.repository.OrderRepository;
import com.epam.javacourse.order.search.OrderSearchCondition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.epam.javacourse.common.solutions.utils.StringUtils.isNotBlank;
import static com.epam.javacourse.storage.Storage.orders;

public class OrderMemoryCollectionRepository implements OrderRepository {
    private OrderOrderingComponent orderingComponent = new OrderOrderingComponent();

    @Override
    public void add(Order entity) {
        entity.setId(SequenceGenerator.getNextValue());
        orders.add(entity);
    }

    @Override
    public void update(Order entity) {

    }

    @Override
    public void deleteById(Long id) {
        Order found = findById(id);
        if (found != null) {
            orders.remove(found);
        }
    }

    @Override
    public List<Order> search(OrderSearchCondition searchCondition) {
        if (searchCondition.getId() != null) {
            return Collections.singletonList(findById(searchCondition.getId()));
        } else {
            List<Order> result = doSearch(searchCondition);

            boolean needOrdering = !result.isEmpty() && searchCondition.needOrdering();
            if (needOrdering) {
                orderingComponent.applyOrdering(result, searchCondition);
            }

            return result;
        }
    }

    @Override
    public void printAll() {
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    @Override
    public Order findById(Long id) {
        return findOrderById(id);
    }

    private Order findOrderById(long orderId) {
        for (Order order : orders) {
            if (Long.valueOf(orderId).equals(order.getId())) {
                return order;
            }
        }
        return null;
    }

    private List<Order> doSearch(OrderSearchCondition searchCondition) {
        String id = String.valueOf(searchCondition.getId());
        boolean searchById = isNotBlank(id);

        List<Order> result = new ArrayList<>();
        for (Order order : orders) {
            if (order != null) {
                boolean found = true;

                if (searchById) {
                    found = id.equals(order.getId());
                }

                if (found) {
                    result.add(order);
                }
            }
        }
        return result;
    }
}
