package com.epam.javacourse.common.solutions.utils;

/**
 * Created by veronika on 01.04.2019.
 */
import java.util.List;

public final class CollectionUtils {
    public static <T> T getLast(List<T> list) {
        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(list.size() - 1);
        }
    }
}
