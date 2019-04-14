package com.epam.javacourse.city.search;

/**
 * Created by veronika on 11.03.2019.
 */
public enum CityOrderByField {
    NAME("city's name"), POPULATION("city's population"), IS_CAPITAL("label if city is capital");

    CityOrderByField(String requestParamName) {
        this.requestParamName = requestParamName;
    }

    private String requestParamName;

    public String getRequestParamName() {
        return requestParamName;
    }
}
