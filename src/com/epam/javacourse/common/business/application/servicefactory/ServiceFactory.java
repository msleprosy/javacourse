package com.epam.javacourse.common.business.application.servicefactory;

import com.epam.javacourse.city.service.CityService;
import com.epam.javacourse.country.service.CountryService;
import com.epam.javacourse.order.service.OrderService;
import com.epam.javacourse.user.service.UserService;

/**
 * Created by veronika on 03.03.2019.
 */
public interface ServiceFactory {
    CountryService getCountryService();
    CityService getCityService();
    OrderService getOrderService();
    UserService getUserService();
}
