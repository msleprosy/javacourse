package com.epam.javacourse.order.repository.implementation;

import com.epam.javacourse.common.business.domain.BaseDomain;
import com.epam.javacourse.common.business.search.BaseSearchCondition;
import com.epam.javacourse.memory.SequenceGenerator;
import com.epam.javacourse.order.domain.Order;
import com.epam.javacourse.order.repository.OrderRepository;
import com.epam.javacourse.order.search.OrderSearchCondition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.epam.javacourse.common.solutions.utils.StringUtils.isNotBlank;
import static com.epam.javacourse.memory.Memory.orders;

public class OrderMemoryCollectionRepository implements OrderRepository {
    private OrderOrderingComponent orderingComponent = new OrderOrderingComponent();

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

    @Override
    public List search(BaseSearchCondition searchCondition) {
        if (searchCondition.getId() != null) {
            return Collections.singletonList(findById(searchCondition.getId()));
        } else {
            List<Order> result = doSearch((OrderSearchCondition) searchCondition);

            boolean needOrdering = !result.isEmpty() && searchCondition.needOrdering();
            if (needOrdering) {
                orderingComponent.applyOrdering(result, ((OrderSearchCondition)searchCondition));
            }

            return result;
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
