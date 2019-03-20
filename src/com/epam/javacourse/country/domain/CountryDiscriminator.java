package com.epam.javacourse.country.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by veronika on 20.03.2019.
 */
public enum CountryDiscriminator {
    COLD_CLIMATE, HOT_CLIMATE;

    static Map<String, CountryDiscriminator> stringCountryDiscriminatorMap = new HashMap<>();

    static {
        for (CountryDiscriminator discriminator : CountryDiscriminator.values()) {
            stringCountryDiscriminatorMap.put(discriminator.name(), discriminator);
        }
    }

    public static CountryDiscriminator getDiscriminatorByName(String discriminatorName) {
        return stringCountryDiscriminatorMap.get(discriminatorName);
    }

    public static boolean isDiscriminatorExists(String discriminator) {
        return getDiscriminatorByName(discriminator) != null;
    }

    public static boolean isDiscriminatorNotExists(String discriminator) {
        return !isDiscriminatorExists(discriminator);
    }
}
