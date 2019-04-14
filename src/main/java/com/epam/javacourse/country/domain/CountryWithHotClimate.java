package com.epam.javacourse.country.domain;

/**
 * Created by veronika on 20.03.2019.
 */
public class CountryWithHotClimate extends Country {
    private String hottestMonth;
    private String averageTemperature;

    public String getHottestMonth() {
        return hottestMonth;
    }

    public void setHottestMonth(String hottestMonth) {
        this.hottestMonth = hottestMonth;
    }

    public String getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(String averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    @Override
    protected void initDiscriminator() {
        discriminator = CountryDiscriminator.HOT_CLIMATE;
    }

    @Override
    public String toString() {
        return super.toString() +
                "CountryWithHotClimate{" +
                "hottestMonth='" + hottestMonth + '\'' +
                ", averageTemperature='" + averageTemperature + '\'' +
                '}';
    }
}
