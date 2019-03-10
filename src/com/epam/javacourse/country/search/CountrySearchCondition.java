package com.epam.javacourse.country.search;

import com.epam.javacourse.common.business.search.BaseSearchCondition;

/**
 * Created by veronika on 28.02.2019.
 */
public class CountrySearchCondition extends BaseSearchCondition {
    private String name;
    private CountryOrderByField orderByField;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CountryOrderByField getOrderByField() {
        return orderByField;
    }

    public void setOrderByField(CountryOrderByField orderByField) {
        this.orderByField = orderByField;
    }

    public boolean needOrdering() {
        return super.needOrdering() && orderByField != null;
    }

}
