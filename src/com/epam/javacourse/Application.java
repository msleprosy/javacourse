package com.epam.javacourse;

import com.epam.javacourse.city.domain.City;
import com.epam.javacourse.city.service.CityService;
import com.epam.javacourse.common.business.application.StorageType;
import com.epam.javacourse.common.business.application.servicefactory.ServiceSupplier;
import com.epam.javacourse.common.solutions.dataclasses.Pair;
import com.epam.javacourse.country.domain.Country;
import com.epam.javacourse.country.search.CountrySearchCondition;
import com.epam.javacourse.country.service.CountryService;
import com.epam.javacourse.order.service.OrderService;
import com.epam.javacourse.user.domain.User;
import com.epam.javacourse.user.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static {
        ServiceSupplier.newInstance(StorageType.MEMORY_COLLECTION);
    }

    private UserService userService = ServiceSupplier.getInstance().getUserService();
    private CountryService countryService = ServiceSupplier.getInstance().getCountryService();
    private CityService cityService = ServiceSupplier.getInstance().getCityService();
    private OrderService orderService = ServiceSupplier.getInstance().getOrderService();

    private void addUsers() {
        String[] usersAsCsv = new String[]{
                "Ivan        | Ivanov | 21",
                "Petr        | Petrov | 23",
                "Dmitry      | yuspov | 31",
                "Dasha       | Jukova | 25",
                "Wlad        | Belyh  | 23",
                "Terminator  | T-800  | 125",
                "Terminator  | T-1000  | 125",
        };
        for (String csvUser : usersAsCsv) {
            String[] userAttrs = csvUser.split("\\|");

            int attrIndex = -1;
            userService.addUser(new User(userAttrs[++attrIndex].trim(),
                    userAttrs[++attrIndex].trim(),
                    Integer.parseInt(userAttrs[++attrIndex].trim())
            ));
        }
    }

    private void addCountriesWithCities() {
        Pair[] countriesWithCities = new Pair[]{
                new Pair("Japan | japanese",
                        new String[]{
                                "Osaka | 10000 | 0 ",
                                "Tokio | 20000 | 1 "
                        }
                ),
                new Pair("Ireland | irish",
                        new String[]{
                                "Dublin | 30000 | 1"
                        }
                ),

                new Pair("England | english",
                        new String[]{
                                "London | 12000 | 1"
                        }
                ),

                new Pair("Russia | russian",
                        new String[]{
                                "Saint-Petersburg   | 40000 | 0",
                                "Moscow | 25000     | 1",
                        }
                ),
        };

        for (Pair countryCityData : countriesWithCities) {
            addCountry(countryCityData.getLeft(), countryCityData.getRight());
        }
    }

    private void addCountry(String countryCsv, String[] citiesCsv) {
        String[] attrs = countryCsv.split("\\|");
        int attrIndex = -1;
        Country country = new Country(attrs[++attrIndex].trim(), attrs[++attrIndex].trim());
        country.setCities(new ArrayList<>());

        for (int i = 0; i < citiesCsv.length; i++) {
            String csvCity = citiesCsv[i];
            attrIndex = -1;
            attrs = csvCity.split("\\|");

            City city = new City();
            city.setName(attrs[++attrIndex].trim());
            city.setPopulation(Integer.parseInt(attrs[++attrIndex].trim()));
            boolean isCapital = Boolean.valueOf(attrs[++attrIndex].trim());
            city.setIsCapital(isCapital);
            country.getCities().add(city);
        }

        countryService.addCountry(country);

    }


    public void fillStorage() {
        addUsers();
        addCountriesWithCities();
    }

    public void printUsers() {
        userService.printAll();
    }

    public void printCountries() {
        countryService.printAll();
    }

    public void deleteUsers() {

        userService.deleteById(1L);
        System.out.println("----------Search countries by name------------");
        CountrySearchCondition countrySearchCondition = new CountrySearchCondition();
        countrySearchCondition.setName("Russia");
        List<Country> searchResult = countryService.search(countrySearchCondition);
        System.out.println("-----Search result----------------------");
        for (Country country : searchResult) {
            System.out.println(country);
        }
        userService.addUser(new User("SSSS", "AAAA", 333));
        userService.deleteById(33L);
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.fillStorage();

        System.out.println("--------Users------------");
        application.printUsers();

        System.out.println("--------Marks------------");
        application.printCountries();

        application.deleteUsers();
        System.out.println();
    }
}
