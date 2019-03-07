package com.epam.javacourse.memory;

public final class SequenceGenerator {
    private static long value = 0;

    private SequenceGenerator() {

    }

    public static long getNextValue() {
        return ++value;
    }
}
