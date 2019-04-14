package com.epam.javacourse.common.solutions.utils;

import java.util.Optional;
import java.util.OptionalInt;

/**
 * Created by veronika on 14.04.2019.
 */
public final class OptionalUtils {

    private OptionalUtils() {
    }

    public static Optional<Integer> valueOf(OptionalInt optionalInt) {
        return optionalInt.isPresent() ? Optional.of(optionalInt.getAsInt()) : Optional.empty();
    }
}
