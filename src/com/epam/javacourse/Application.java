package com.epam.javacourse;

import com.epam.javacourse.city.domain.City;
import com.epam.javacourse.city.search.CityOrderByField;
import com.epam.javacourse.city.search.CitySearchCondition;
import com.epam.javacourse.city.service.CityService;
import com.epam.javacourse.common.business.application.StorageType;
import com.epam.javacourse.common.business.application.servicefactory.ServiceSupplier;
import com.epam.javacourse.common.business.exception.TravelAgencyCheckedException;
import com.epam.javacourse.common.business.search.OrderDirection;
import com.epam.javacourse.common.business.search.OrderType;
import com.epam.javacourse.common.solutions.utils.FileUtils;
import com.epam.javacourse.country.domain.Country;
import com.epam.javacourse.country.search.CountryOrderByField;
import com.epam.javacourse.country.search.CountrySearchCondition;
import com.epam.javacourse.country.service.CountryService;
import com.epam.javacourse.order.domain.Order;
import com.epam.javacourse.order.service.OrderService;
import com.epam.javacourse.reporting.ReportProvider;
import com.epam.javacourse.storage.initor.StorageInitor;
import com.epam.javacourse.storage.initor.StorageInitorConstants;
import com.epam.javacourse.user.domain.User;
import com.epam.javacourse.user.search.UserOrderByField;
import com.epam.javacourse.user.search.UserSearchCondition;
import com.epam.javacourse.user.service.UserService;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.epam.javacourse.common.solutions.utils.RandomUtils.getRandomInt;

public class Application {
    static {
        ServiceSupplier.newInstance(StorageType.MEMORY_COLLECTION);
    }

    private UserService userService = ServiceSupplier.getInstance().getUserService();
    private CountryService countryService = ServiceSupplier.getInstance().getCountryService();
    private CityService cityService = ServiceSupplier.getInstance().getCityService();
    private OrderService orderService = ServiceSupplier.getInstance().getOrderService();

    public void fillStorage() throws Exception {
        addUsers();
        StorageInitor storageInitor = new StorageInitor(countryService);
        File fileWithInitData = null;
        try {
            fileWithInitData = FileUtils
                    .createFileFromResource("init-data", ".txt", StorageInitorConstants.INIT_DATA_TXT_FILE);
            storageInitor.initStorageWithCountriesAndCities(fileWithInitData.getAbsolutePath(), StorageInitor.DataSourceType.TXT_FILE);
        } catch (TravelAgencyCheckedException e) {
            System.out.println("ERROR while init storage: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            System.out.println("Error: Unknown magic :" + e.getMessage());
            throw e;
        } finally {
            if (fileWithInitData != null) {
                Files.delete(Paths.get(fileWithInitData.toURI()));
            }
        }
        appendOrdersToUsers();

    }

    private void addUsers() {
        String[] usersAsCsv = new String[]{
                "Dmitry        | yuspov | 21",
                "Petr        | Petrov | 23",
                "Dmitry      | Ivanov | 31",
                "Dasha       | Jukova | 25",
                "Wlad        | Belyh  | 23",
                "Terminator  | T-800  | 125",
                "Terminator  | T-1000  | 125",
        };
        for (String csvUser : usersAsCsv) {
            String[] userAttrs = csvUser.split("\\|");

            int attrIndex = -1;
            userService.add(new User(userAttrs[++attrIndex].trim(),
                    userAttrs[++attrIndex].trim(),
                    userAttrs[++attrIndex].trim())
            );
        }
    }

    private void appendOrdersToUsers() {
        List<Country> countries = countryService.findAll();
        List<User> users = userService.findAll();

        List<Order> orders = new ArrayList<>();
        int i = 0;
        for (User user : users) {
            i++;
            orders.add(prepareOrderForUser(user, countries));

            if (i % 2 == 0) {
                orders.add(prepareOrderForUser(user, countries));
            }
        }

        for (Order order : orders) {
            orderService.add(order);
        }
    }

    private Order prepareOrderForUser(User user, List<Country> countries) {
        Order order = new Order();
        order.setUser(user);
        Country country = countries.get(getRandomInt(0, countries.size() - 1));
        order.setCountry(country);
        order.setCity(country.getCities().get(getRandomInt(0, country.getCities().size() - 1)));
        order.setPrice(getRandomInt(1, 100000));

        return order;
    }

/*    private void addCountriesWithCities() {
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
        country.setCities(new City[citiesCsv.length]);

        for (int i = 0; i < citiesCsv.length; i++) {
            String csvCity = citiesCsv[i];
            attrIndex = -1;
            attrs = csvCity.split("\\|");

            City city = new City();
            city.setName(attrs[++attrIndex].trim());
            city.setPopulation(Integer.parseInt(attrs[++attrIndex].trim()));
            boolean isCapital = Boolean.valueOf(attrs[++attrIndex].trim());
            city.setIsCapital(isCapital);
            //country.getCities().add(city);
            country.getCities()[i] = city;
        }

        countryService.add(country);

    }
*/

   /* public void fillStorage() {
        addUsers();
        addCountriesWithCities();
    }*/

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
        userService.add(new User("SSSS", "AAAA", "333"));
        userService.deleteById(33L);
    }

    public void searchCountriesWithoutOrder() {
        System.out.println("\n----------Search countries No order ------------");
        CountrySearchCondition countrySearchCondition = new CountrySearchCondition();
        List<Country> searchResult = countryService.search(countrySearchCondition);
        for (Country country : searchResult) {
            System.out.println(country.getAsStrWithoutCities());
        }
    }

    public void searchCountriesWithOrderAsc() {
        System.out.println("\n----------Search countries Order ASC ------------");
        CountrySearchCondition countrySearchCondition = new CountrySearchCondition();
        countrySearchCondition.setOrderDirection(OrderDirection.ASC);
        countrySearchCondition.setOrderByField(CountryOrderByField.NAME);
        List<Country> searchResult = countryService.search(countrySearchCondition);
        for (Country country : searchResult) {
            System.out.println(country.getAsStrWithoutCities());
        }
    }

    public void searchCountriesWithOrderDesc() {
        System.out.println("\n----------Search countries Order Desc ------------");
        CountrySearchCondition countrySearchCondition = new CountrySearchCondition();
        countrySearchCondition.setOrderDirection(OrderDirection.DESC);
        countrySearchCondition.setOrderByField(CountryOrderByField.NAME);
        List<Country> searchResult = countryService.search(countrySearchCondition);
        for (Country country : searchResult) {
            System.out.println(country.getAsStrWithoutCities());
        }
    }

    public void searchCountriesWithComplexOrderAsc() {
        System.out.println("\n----------Search countries COMPLEX Order Asc ------------");
        CountrySearchCondition countrySearchCondition = new CountrySearchCondition();
        countrySearchCondition.setOrderDirection(OrderDirection.ASC);
        countrySearchCondition.setOrderByField(CountryOrderByField.NAME);
        countrySearchCondition.setOrderType(OrderType.COMPLEX);
        List<Country> searchResult = countryService.search(countrySearchCondition);
        for (Country country : searchResult) {
            System.out.println(country.getAsStrWithoutCities());
        }
    }

    public void searchCountriesWithComplexOrderDesc() {
        System.out.println("\n----------Search countries COMPLEX Order Desc ------------");
        CountrySearchCondition countrySearchCondition = new CountrySearchCondition();
        countrySearchCondition.setOrderDirection(OrderDirection.DESC);
        countrySearchCondition.setOrderByField(CountryOrderByField.NAME);
        countrySearchCondition.setOrderType(OrderType.COMPLEX);
        List<Country> searchResult = countryService.search(countrySearchCondition);
        for (Country country : searchResult) {
            System.out.println(country.getAsStrWithoutCities());
        }
    }

    public void searchUsersWithOrderAsc() {
        System.out.println("\n----------Search users Order ASC ------------");
        UserSearchCondition userSearchCondition = new UserSearchCondition();
        userSearchCondition.setOrderDirection(OrderDirection.ASC);
        userSearchCondition.setOrderByField(UserOrderByField.NAME);
        List<User> searchResult = userService.search(userSearchCondition);
        for (User user : searchResult) {
            System.out.println(user.getUserAsStr());
        }
    }


    public void searchUsersWithOrderDesc() {
        System.out.println("\n----------Search users Order Desc ------------");
        UserSearchCondition userSearchCondition = new UserSearchCondition();
        userSearchCondition.setOrderDirection(OrderDirection.DESC);
        userSearchCondition.setOrderByField(UserOrderByField.LASTNAME);
        List<User> searchResult = userService.search(userSearchCondition);
        for (User user : searchResult) {
            System.out.println(user.getUserAsStr());
        }
    }

    public void searchUsersWithComplexOrderAsc() {
        System.out.println("\n----------Search users Order ASC ------------");
        UserSearchCondition userSearchCondition = new UserSearchCondition();
        userSearchCondition.setOrderDirection(OrderDirection.ASC);
        userSearchCondition.setOrderByField(UserOrderByField.NAME);
        userSearchCondition.setOrderType(OrderType.COMPLEX);
        List<User> searchResult = userService.search(userSearchCondition);
        for (User user : searchResult) {
            System.out.println(user.getUserAsStr());
        }
    }

    public void searchCitiesWithOrderAsc() {
        System.out.println("\n----------Search cities Order ASC ------------");
        CitySearchCondition citySearchCondition = new CitySearchCondition();
        citySearchCondition.setOrderDirection(OrderDirection.ASC);
        citySearchCondition.setOrderByField(CityOrderByField.NAME);
        List<City> searchResult = cityService.search(citySearchCondition);
        for (City country : searchResult) {
            System.out.println(country.getCityAsStr());
        }
    }

    public void demoReporting() {
        ReportProvider reportProvider = new ReportProvider(userService, orderService, countryService, cityService);

        File fileWithReport = null;
        try {
            fileWithReport = reportProvider.getUserOrdersTextFileReport();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (fileWithReport != null) {
                System.out.println("File with report '" + fileWithReport.getAbsolutePath() + "'");
                    /*
                    //uncomment line to delete temp file
                    boolean deleted = fileWithReport.delete();
                    if (!deleted) {
                        System.out.println("OOps, can't delete file " + fileWithReport.getAbsolutePath());
                    }*/
            }
        }
    }


    public static void main(String[] args) throws Exception {
        Application application = new Application();
        application.fillStorage();

        System.out.println("--------Users------------");
        application.printUsers();

        System.out.println("--------Countries------------");
        application.printCountries();

        application.searchCountriesWithoutOrder();

        application.searchCountriesWithOrderAsc();

        application.searchCountriesWithOrderDesc();

        application.searchCountriesWithComplexOrderDesc();

        application.searchCountriesWithComplexOrderAsc();

        application.searchUsersWithOrderAsc();

        application.searchUsersWithOrderDesc();

        application.searchUsersWithComplexOrderAsc();

        application.searchCitiesWithOrderAsc();


        application.deleteUsers();
        System.out.println();
    }
}
