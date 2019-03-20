package com.epam.javacourse.country.domain;

import com.epam.javacourse.city.domain.City;
import com.epam.javacourse.common.business.domain.BaseDomain;

import java.util.List;

public class Country extends BaseDomain {
    private String name;
    private String language;
    private List<City> cities;

    public Country(String name, String language) {
        this.name = name;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id = " + id +
                ", name = " + name + '\'' +
                ", language = " + language + '\'' +
                ", \n\ncities:\n" + getCitiesAsStr();
    }

    public String getAsStrWithoutCities() {
        return "id = " + id +
                ", name = '" + name + '\'' +
                ", language = '" + language + '\'';

    }

    private String getCitiesAsStr() {
        StringBuilder stringBuilder = new StringBuilder();
        for (City city : cities) {
            stringBuilder.append(city.toString()).append("\n");
        }

        return stringBuilder.toString();
    }
}

