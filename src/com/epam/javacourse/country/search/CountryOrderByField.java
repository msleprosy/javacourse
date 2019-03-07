package com.epam.javacourse.country.search;

/**
 * Created by veronika on 07.03.2019.
 */
public enum CountryOrderByField {
    NAME("countryname");

    CountryOrderByField(String requestParamName) {
        this.requestParamName = requestParamName;
    }

    private String requestParamName;

    public String getRequestParamName() {
        return requestParamName;
    }
}
