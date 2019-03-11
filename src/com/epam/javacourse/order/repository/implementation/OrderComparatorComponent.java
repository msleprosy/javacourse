package com.epam.javacourse.order.repository.implementation;

import com.epam.javacourse.order.domain.Order;
import com.epam.javacourse.order.search.OrderByField;

import java.util.*;

import static com.epam.javacourse.common.business.repository.memory.CommonComparatorHolder.getComparatorForNullableStrings;
import static com.epam.javacourse.order.search.OrderByField.*;

/**
 * Created by veronika on 11.03.2019.
 */
public class OrderComparatorComponent {
    private static final OrderComparatorComponent INSTANCE = new OrderComparatorComponent();
    private static Map<OrderByField, Comparator<Order>> comparatorsByField = new HashMap<>();
    /**
     * For complex comparator only
     */
    private static Set<OrderByField> fieldComparePriorityOrder = new LinkedHashSet<>(Arrays.asList(PRICE, USER, COUNTRY, CITY));

    static {
        comparatorsByField.put(PRICE, getComparatorForPriceField());
        comparatorsByField.put(USER, getComparatorForUserNameField());
        comparatorsByField.put(COUNTRY, getComparatorForCountryNameField());
        comparatorsByField.put(COUNTRY, getComparatorForCityNameField());
    }

    private OrderComparatorComponent() {
    }


    public static OrderComparatorComponent getInstance() {
        return INSTANCE;
    }

    private static Comparator<Order> getComparatorForPriceField() {
        return new Comparator<Order>() {
            @Override
            public int compare(Order order1, Order order2) {
                String price1 = String.valueOf(order1.getPrice());
                String price2 = String.valueOf(order2.getPrice());
                return getComparatorForNullableStrings().compare(price1, price2);
            }
        };
    }

    private static Comparator<Order> getComparatorForUserNameField() {
        return new Comparator<Order>() {
            @Override
            public int compare(Order order1, Order order2) {
                return getComparatorForNullableStrings().compare(order1.getUser().getName(), order2.getUser().getName());
            }
        };
    }

    private static Comparator<Order> getComparatorForCountryNameField() {
        return new Comparator<Order>() {
            @Override
            public int compare(Order order1, Order order2) {
                return getComparatorForNullableStrings().compare(order1.getCountry().getName(), order2.getCountry().getName());
            }
        };
    }
    private static Comparator<Order> getComparatorForCityNameField() {
        return new Comparator<Order>() {
            @Override
            public int compare(Order order1, Order order2) {
                return getComparatorForNullableStrings().compare(order1.getCity().getName(), order2.getCity().getName());
            }
        };
    }


    public Comparator<Order> getComparatorForField(OrderByField field) {
        return comparatorsByField.get(field);
    }

    public Comparator<Order> getComplexComparator(OrderByField field) {
        return new Comparator<Order>() {

            @Override
            public int compare(Order o1, Order o2) {
                int result = 0;
                Comparator<Order> orderComparator = comparatorsByField.get(field);

                if (orderComparator != null) {
                    result = orderComparator.compare(o1, o2);
                    //if records have same order priority, i want to order them in their group
                    if (result == 0) {

                        //loop throug all possible sorting fields
                        for (OrderByField otherField : fieldComparePriorityOrder) {
                            //if i haven't sorted by field which is taken from parameter in function, i do sorting
                            if (!otherField.equals(field)) {

                                result = comparatorsByField.get(otherField).compare(o1, o2);
                                //if sort result detected that records are not equals - we exit from loop,
                                //else continue
                                if (result != 0) {
                                    break;
                                }
                            }
                        }

                    }
                }
                return result;
            }
        };
    }
}
