package com.epam.javacourse.city.repository.implementation;

import com.epam.javacourse.city.domain.City;
import com.epam.javacourse.city.repository.CityRepository;
import com.epam.javacourse.city.search.CitySearchCondition;
import com.epam.javacourse.storage.SequenceGenerator;

import java.util.*;

import static com.epam.javacourse.common.solutions.utils.StringUtils.isNotBlank;
import static com.epam.javacourse.storage.Storage.cities;

public class CityMemoryCollectionRepository implements CityRepository {
    private CityOrderingComponent orderingComponent = new CityOrderingComponent();

    @Override
    public City add(City city) {
        city.setId(SequenceGenerator.getNextValue());
        cities.add(city);
        return city;
    }

    @Override
    public void add(Collection<City> cities) {
        cities.forEach(this::add);
    }

    @Override
    public void update(City entity) {

    }

    @Override
    public void deleteById(Long id) {
        findCityById(id).map(city -> cities.remove(city));
    }

    @Override
    public List<? extends City> search(CitySearchCondition searchCondition) {
        if (searchCondition.getId() != null) {
            return Collections.singletonList(findById(searchCondition.getId()));
        } else {
            List<City> result = doSearch(searchCondition);

            boolean needOrdering = !result.isEmpty() && searchCondition.needOrdering();
            if (needOrdering) {
                orderingComponent.applyOrdering(result, searchCondition);
            }

            return result;
        }
    }

    @Override
    public Optional<City> findById(Long id) {
        return findCityById(id);
    }

    @Override
    public void printAll() {
         cities.forEach(System.out::println);
    }

    private List<City> doSearch(CitySearchCondition searchCondition) {
        boolean searchByName = isNotBlank(searchCondition.getName());

        List<City> result = new ArrayList<>();
        for (City city : cities) {
            if (city != null) {
                boolean found = true;

                if (searchByName) {
                    found = searchCondition.getName().equals(city.getName());
                }

                if (found) {
                    result.add(city);
                }
            }
        }
        return result;
    }


    private Optional<City> findCityById(long cityId) {
        return cities.stream().filter(city -> Long.valueOf(cityId).equals(city.getId())).findAny();
    }

    @Override
    public List<City> findAll() {
        return cities;
    }

    @Override
    public int countAll() {
        return cities.size();
    }
}
