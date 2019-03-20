package com.epam.javacourse.common.business.exception;

/**
 * Created by veronika on 20.03.2019.
 */
public abstract class TravelAgencyCheckedException extends Exception {

    protected int code;

    public TravelAgencyCheckedException(int code, String message) {
        super(message);
        this.code = code;
    }

    public TravelAgencyCheckedException(int code, String message, Exception cause) {
        super(message);
        this.code = code;
        initCause(cause);
    }
}

