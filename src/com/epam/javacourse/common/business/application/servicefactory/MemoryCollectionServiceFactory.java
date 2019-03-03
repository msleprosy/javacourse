package com.epam.javacourse.common.business.application.servicefactory;

import com.epam.javacourse.city.repository.implementation.CityMemoryCollectionRepository;
import com.epam.javacourse.city.service.CityService;
import com.epam.javacourse.city.service.implementation.CityDefaultService;
import com.epam.javacourse.country.repository.implementation.CountryMemoryCollectionRepository;
import com.epam.javacourse.country.service.CountryService;
import com.epam.javacourse.country.service.implementation.CountryDefaultService;
import com.epam.javacourse.order.repository.implementation.OrderMemoryCollectionRepository;
import com.epam.javacourse.order.service.OrderService;
import com.epam.javacourse.order.service.implementation.OrderDefaultService;
import com.epam.javacourse.user.repository.implementation.UserMemoryCollectionRepository;
import com.epam.javacourse.user.service.UserService;
import com.epam.javacourse.user.service.implementation.UserDefaultService;

/**
 * Created by veronika on 03.03.2019.
 */
public class MemoryCollectionServiceFactory implements ServiceFactory{
    @Override
    public CountryService getCountryService() {
        return new CountryDefaultService(new CountryMemoryCollectionRepository(), new CityMemoryCollectionRepository());
    }

    @Override
    public CityService getCityService() {
        return new CityDefaultService(new CityMemoryCollectionRepository());
    }

    @Override
    public OrderService getOrderService() {
        return new OrderDefaultService(new OrderMemoryCollectionRepository(), new UserDefaultService(new UserMemoryCollectionRepository()));
    }

    @Override
    public UserService getUserService() {
        return new UserDefaultService(new UserMemoryCollectionRepository());
    }
}
