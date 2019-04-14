package com.epam.javacourse.storage.initor.exception;

/**
 * Created by veronika on 20.03.2019.
 */
public enum InitDataExceptionMeta {

    PARSE_COUNTRY_DISCRIMINATOR_ERROR(1, "Unknown country discriminator '%s'.");

    private int code;
    private String description;

    InitDataExceptionMeta(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getDescriptionAsFormatStr(Object... args) {
        return String.format(description, args);
    }
}

