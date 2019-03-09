package com.epam.javacourse.city.domain;

import com.epam.javacourse.common.business.domain.BaseDomain;

public class City extends BaseDomain {
    private String name;
    private int population;
    private boolean isCapital;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public boolean getIsCapital() {
        return isCapital;
    }

    public void setIsCapital(boolean capital) {
        isCapital = capital;
    }

    @Override
    public String toString() {
        return "City{" +
                "id = " + id +
                ", name = " + name + '\'' +
                ", population = " + population +
                ", isCapital = " + isCapital +
                "}";
    }
}
