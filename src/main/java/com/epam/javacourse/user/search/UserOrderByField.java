package com.epam.javacourse.user.search;

/**
 * Created by veronika on 10.03.2019.
 */
public enum UserOrderByField {
    NAME("user's name"), LASTNAME("user's lastname");

    UserOrderByField(String requestParamName) {
        this.requestParamName = requestParamName;
    }

    private String requestParamName;

    public String getRequestParamName() {
        return requestParamName;
    }
}
