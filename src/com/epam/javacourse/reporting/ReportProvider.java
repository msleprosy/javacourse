package com.epam.javacourse.reporting;

import com.epam.javacourse.city.service.CityService;
import com.epam.javacourse.country.service.CountryService;
import com.epam.javacourse.order.service.OrderService;
import com.epam.javacourse.user.service.UserService;

import java.io.File;

/**
 * Created by veronika on 21.03.2019.
 */
public class ReportProvider {

    private final UserService userService;
    private final OrderService orderService;
    private final CountryService countryService;
    private final CityService cityService;

    private ReportComponent userOrdersTextFileReport;

    public ReportProvider(UserService userService, OrderService orderService,
                          CountryService countryService, CityService cityService) {
        this.userService = userService;
        this.orderService = orderService;
        this.countryService = countryService;
        this.cityService = cityService;

        initReportComponents();
    }

    private void initReportComponents() {
        userOrdersTextFileReport = new UserOrdersIoTextFileReport(
                userService,
                orderService,
                countryService,
                cityService);
    }

    public File getUserOrdersTextFileReport() throws Exception {
        return userOrdersTextFileReport.generateReport();
    }

}

