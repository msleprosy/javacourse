package com.epam.javacourse.country.exception;

import com.epam.javacourse.common.business.exception.TravelAgencyUncheckedException;

public class DeleteCountryException extends TravelAgencyUncheckedException {

    public DeleteCountryException(int code, String message) {
        super(code, message);
    }

    public DeleteCountryException(CountryExceptionMeta exceptionMeta) {
        super(exceptionMeta.getCode(), exceptionMeta.getDescription());
    }
}
