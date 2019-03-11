package com.epam.javacourse.city.repository.implementation;

import com.epam.javacourse.city.domain.City;
import com.epam.javacourse.city.repository.CityRepository;
import com.epam.javacourse.city.search.CitySearchCondition;
import com.epam.javacourse.common.business.domain.BaseDomain;
import com.epam.javacourse.memory.SequenceGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static com.epam.javacourse.common.solutions.utils.StringUtils.isNotBlank;
import static com.epam.javacourse.memory.Memory.cities;

public class CityMemoryCollectionRepository implements CityRepository {
    private CityOrderingComponent orderingComponent = new CityOrderingComponent();

    @Override
    public void add(BaseDomain city) {
        city.setId(SequenceGenerator.getNextValue());
        cities.add((City)city);
    }

    @Override
    public void update(BaseDomain type) {

    }

    @Override
    public void deleteById(long id) {
        City found = findCityById(id);
        if (found != null) {
            cities.remove(found);
        }
    }

    @Override
    public void deleteByName(String nameForDeleting) {
        deleteCityByName(nameForDeleting);
    }

   /* @Override
    public void update(City city) {

    }*/

   /* @Override
    public City findByName(String cityName) {
        for (City city : cities) {
            if (cityName.equals(city.getName())) {
                return city;
            }
        }
        return null;
    }*/

    @Override
    public List<City> search(CitySearchCondition searchCondition) {
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
    public void printAll() {
        for (City city : cities) {
            System.out.println(city);
        }
    }


    private City findById(long id) {
        return findCityById(id);
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


    private City findCityById(long citylId) {
        for (City city : cities) {
            if (Long.valueOf(citylId).equals(city.getId())) {
                return city;
            }
        }
        return null;
    }

    private void deleteCityByName(String nameForDeleting) {
        Iterator<City> iter = cities.iterator();
        while (iter.hasNext()) {
            String cityName = iter.next().getName();
            if (cityName.equals(nameForDeleting)) {
                iter.remove();
            }
        }
    }
}
