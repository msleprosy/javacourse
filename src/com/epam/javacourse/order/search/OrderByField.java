package com.epam.javacourse.order.search;

/**
 * Created by veronika on 11.03.2019.
 */
public enum OrderByField {
    PRICE("order's price"), USER("user's name"), COUNTRY("country's name"), CITY("city's name");

    OrderByField(String requestParamName) {
        this.requestParamName = requestParamName;
    }

    private String requestParamName;

    public String getRequestParamName() {
        return requestParamName;
    }
}
