package com.epam.javacourse.country.domain;

/**
 * Created by veronika on 20.03.2019.
 */
public class CountryWithColdClimate extends Country {
    private String phoneCode;
    private boolean withPolarNight;

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public boolean isWithPolarNight() {
        return withPolarNight;
    }

    public void setWithPolarNight(boolean withPolarNight) {
        this.withPolarNight = withPolarNight;
    }

    @Override
    protected void initDiscriminator() {
        discriminator = CountryDiscriminator.COLD_CLIMATE;
    }

    @Override
    public String toString() {
        return super.toString() +
                "CountryWithColdClimate{" +
                "phoneCode='" + phoneCode + '\'' +
                ", withPolarNight=" + withPolarNight +
                '}';
    }
}
