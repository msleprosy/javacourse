package com.epam.javacourse.common.business.application;

import com.epam.javacourse.city.service.CityService;
import com.epam.javacourse.country.service.CountryService;
import com.epam.javacourse.order.service.OrderService;
import com.epam.javacourse.user.service.UserService;

/**
 * Created by veronika on 28.02.2019.
 */
public final class ApplicationServiceCreator {

    private ApplicationServiceCreator() {

    }

    public static CountryService getCountryService(StorageType storageType) {
        return CountryServiceCreator.getCountryService(storageType);
    }

    public static CityService getCityService(StorageType storageType) {
        return CityServiceCreator.getCityService(storageType);
    }

    public static OrderService getOrderService(StorageType storageType) {
        return OrderServiceCreator.getOrderService(storageType);
    }

    public static UserService getUserService(StorageType storageType) {
        return UserServiceCreator.getUserService(storageType);
    }
}
