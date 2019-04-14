package com.epam.javacourse.common.solutions.utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by veronika on 21.03.2019.
 */

public final class RandomUtils {

    private RandomUtils() {
    }

    public static int getRandomInt(int start, int end){
        return ThreadLocalRandom.current().nextInt(start, end + 1);
    }
}
