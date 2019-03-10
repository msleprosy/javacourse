package com.epam.javacourse.user.search;

import com.epam.javacourse.common.business.search.BaseSearchCondition;

public class UserSearchCondition extends BaseSearchCondition {
    private String name;
    private String lastName;
    private UserOrderByField orderByField;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserOrderByField getOrderByField() {
        return orderByField;
    }

    public void setOrderByField(UserOrderByField orderByField) {
        this.orderByField = orderByField;
    }

    public boolean needOrdering() {
        return super.needOrdering() && orderByField != null;
    }
}
