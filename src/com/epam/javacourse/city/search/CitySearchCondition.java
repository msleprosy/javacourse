package com.epam.javacourse.city.search;

import com.epam.javacourse.common.business.search.BaseSearchCondition;

/**
 * Created by veronika on 28.02.2019.
 */
public class CitySearchCondition extends BaseSearchCondition {

    private String name;
    private boolean isCapital;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }
}
