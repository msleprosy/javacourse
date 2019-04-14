package com.epam.javacourse.user.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by veronika on 07.03.2019.
 */
public enum ClientType {
    VIP("Very important person"),
    SIMPLE("Just another client"),
    IN_THE_BLACK_LIST("Ignore him");

    private String description;

    private static Map<String, ClientType> strNameEnumItemMap;

    static {
        strNameEnumItemMap = new HashMap<>();
        for (ClientType enumItem : ClientType.values()) {
            strNameEnumItemMap.put(enumItem.name(), enumItem);
        }
    }

    ClientType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static boolean isStrBelongsToEnumValues(String enumItemAsStr) {
        return strNameEnumItemMap.containsKey(enumItemAsStr);
    }

    public static ClientType getEnumFromEnumName(String enumName) {
        return strNameEnumItemMap.get(enumName);
    }
}

