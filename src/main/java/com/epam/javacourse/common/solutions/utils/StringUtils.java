package com.epam.javacourse.common.solutions.utils;

/**
 * Created by veronika on 28.02.2019.
 */
public final class StringUtils {

    private StringUtils() {

    }

    public static boolean isBlank(String s) {
        return s == null || s.isEmpty();
    }

    public static boolean isNotBlank(String s) {
        return !isBlank(s);
    }
}
