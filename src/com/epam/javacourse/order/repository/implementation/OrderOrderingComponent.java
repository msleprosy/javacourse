package com.epam.javacourse.order.repository.implementation;

import com.epam.javacourse.order.domain.Order;
import com.epam.javacourse.order.search.OrderByField;
import com.epam.javacourse.order.search.OrderSearchCondition;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by veronika on 11.03.2019.
 */
public class OrderOrderingComponent {
    class MyComparable implements Comparable<String> {

        private String srcString;
        private boolean invert = false;

        public MyComparable(String srcString) {
            this.srcString = srcString;
        }

        @Override
        public int compareTo(String o) {
            if (invert) {
                return (-1) * this.srcString.compareTo(o);
            } else {
                return this.srcString.compareTo(o);
            }
        }
    }

    public void applyOrdering(List<Order> users, OrderSearchCondition orderSearchCondition) {
        Comparator<Order> orderComparator = null;
        OrderByField field = orderSearchCondition.getOrderByField();
        switch (orderSearchCondition.getOrderType()) {

            case SIMPLE: {
                orderComparator = OrderComparatorComponent.getInstance().getComparatorForField(field);
                break;
            }
            case COMPLEX: {
                orderComparator = OrderComparatorComponent.getInstance().getComplexComparator(field);
                break;
            }
        }

        if (orderComparator != null) {
            switch (orderSearchCondition.getOrderDirection()) {

                case ASC:
                    Collections.sort(users, orderComparator);
                    break;
                case DESC:
                    Collections.sort(users, orderComparator.reversed());
                    break;
            }
        }
    }

}
