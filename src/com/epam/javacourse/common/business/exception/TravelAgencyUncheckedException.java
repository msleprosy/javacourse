package com.epam.javacourse.common.business.exception;

/**
 * Created by veronika on 20.03.2019.
 */
public abstract class TravelAgencyUncheckedException extends RuntimeException {
    protected int code;

    public TravelAgencyUncheckedException(int code, String message) {
        super(message);
        this.code = code;
    }

    public TravelAgencyUncheckedException(int code, String message, Exception cause) {
        super(message);
        this.code = code;
        initCause(cause);
    }
}
