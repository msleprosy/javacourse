package com.epam.javacourse.country.service.implementation;

import com.epam.javacourse.city.repository.CityRepository;
import com.epam.javacourse.city.service.CityService;
import com.epam.javacourse.common.business.exception.TravelAgencyUncheckedException;
import com.epam.javacourse.country.domain.Country;
import com.epam.javacourse.country.exception.DeleteCountryException;
import com.epam.javacourse.country.repository.CountryRepository;
import com.epam.javacourse.country.search.CountrySearchCondition;
import com.epam.javacourse.country.service.CountryService;
import com.epam.javacourse.order.repository.OrderRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.epam.javacourse.country.exception.CountryExceptionMeta.DELETE_COUNTRY_CONSTRAINT_ERROR;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

public class CountryDefaultService implements CountryService {
    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;
    private final CityService cityService;
    private final OrderRepository orderRepository;

    public CountryDefaultService(CountryRepository countryRepository, CityRepository cityRepository, CityService cityService, OrderRepository orderRepository) {
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
        this.cityService = cityService;
        this.orderRepository = orderRepository;
    }

    @Override
    public Country add(Country country) {
        if (country != null) {
        countryRepository.add(country);

            if (isNotEmpty(country.getCities())) {
                country.getCities().forEach(city -> {
                    city.setCountryId(country.getId());
                    cityService.add(city);
                });
            }
        }

        return country;
    }

    @Override
    public void add(Collection<Country> countries) {
        if (countries != null && !countries.isEmpty()) {
            for (Country country : countries) {
                countryRepository.add(country);

                if (isNotEmpty(country.getCities())) {
                    country.getCities().replaceAll(city -> {
                        city.setCountryId(country.getId());
                        return city;
                    });
                    cityService.add(country.getCities());
                }
            }
        }
    }


    @Override
    public void update(Country entity) {
    }

    @Override
    public Optional<Country> findById(Long id) {
        if (id != null) {
            return countryRepository.findById(id);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) throws TravelAgencyUncheckedException {
        if (id != null) {
            boolean noOrders = orderRepository.countByCountry(id) == 0;

            if (noOrders) {
                removeAllCitiesFromCountry(id);
                countryRepository.deleteById(id);
            } else {
                throw new DeleteCountryException(DELETE_COUNTRY_CONSTRAINT_ERROR);
            }
        }
    }

    @Override
    public void removeAllCitiesFromCountry(Long countryId) throws TravelAgencyUncheckedException {
        findById(countryId).ifPresent(country -> {
            if (country.getCities() != null) {
                country.getCities().forEach(city -> cityService.deleteById(city.getId()));
            }
        });
    }

    @Override
    public void delete(Country entity) {
        if (entity.getId() != null) {
            this.deleteById(entity.getId());
        }
    }

    @Override
    public void printAll() {
        countryRepository.printAll();
    }

    @Override
    public List<Country> search(CountrySearchCondition searchCondition) {
        if (searchCondition.getId() != null) {
            return countryRepository.findById(searchCondition.getId()).map(Collections::singletonList).orElse(Collections.emptyList());
        } else {
            return countryRepository.search(searchCondition);
        }
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public int countAll() {
        return countryRepository.countAll();
    }
}
