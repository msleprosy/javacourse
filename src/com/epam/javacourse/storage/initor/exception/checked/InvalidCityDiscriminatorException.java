package com.epam.javacourse.storage.initor.exception.checked;

import com.epam.javacourse.common.business.exception.TravelAgencyCheckedException;

/**
 * Created by veronika on 20.03.2019.
 */
public class InvalidCityDiscriminatorException extends TravelAgencyCheckedException {

    public InvalidCityDiscriminatorException(int code, String message) {
        super(code, message);
    }
}
