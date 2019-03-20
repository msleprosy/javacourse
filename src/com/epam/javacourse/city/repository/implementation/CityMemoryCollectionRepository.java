package com.epam.javacourse.city.repository.implementation;

import com.epam.javacourse.city.domain.City;
import com.epam.javacourse.city.repository.CityRepository;
import com.epam.javacourse.city.search.CitySearchCondition;
import com.epam.javacourse.storage.SequenceGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.epam.javacourse.common.solutions.utils.StringUtils.isNotBlank;
import static com.epam.javacourse.storage.Storage.cities;

public class CityMemoryCollectionRepository implements CityRepository {
    private CityOrderingComponent orderingComponent = new CityOrderingComponent();

    @Override
    public void add(City entity) {
        entity.setId(SequenceGenerator.getNextValue());
        cities.add(entity);
    }

    @Override
    public void update(City entity) {

    }

    @Override
    public void deleteById(Long id) {
        City found = findCityById(id);
        if (found != null) {
            cities.remove(found);
        }
    }

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
    public City findById(Long id) {
            return findCityById(id);
    }

    @Override
    public void printAll() {
        for (City city : cities) {
            System.out.println(city);
        }
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

/*    private void deleteCityByName(String nameForDeleting) {
        Iterator<City> iter = cities.iterator();
        while (iter.hasNext()) {
            String cityName = iter.next().getName();
            if (cityName.equals(nameForDeleting)) {
                iter.remove();
            }
        }
    }*/
}
