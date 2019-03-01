package com.epam.javacourse.city.repository.implementation;

import com.epam.javacourse.city.domain.City;
import com.epam.javacourse.city.repository.CityRepository;

import java.util.Iterator;

import static com.epam.javacourse.memory.Memory.cities;

public class CityMemoryCollectionRepository implements CityRepository {

    @Override
    public void addCity(City city) {
        cities.add(city);
    }

    @Override
    public void updateCityName(String currentCityName, String newCityName) {
        for (City city : cities) {
            if (city.getName().equals(currentCityName)) {
                city.setName(newCityName);
            }
        }
    }

    @Override
    public void updateCityPopulation(String cityName, int currentCityPopulation, int newCityPopulation) {
        for (City city : cities) {
            if (city.getName().equals(cityName)) {
                if (city.getPopulation() == currentCityPopulation) {
                    city.setPopulation(newCityPopulation);
                }
            }
        }
    }

    @Override
    public void updateTheCapitalMark(String cityName) {
        for (City city : cities) {
            if (city.getName().equals(cityName)) {
                if (city.getIsCapital() == true) {
                    city.setIsCapital(false);
                } else {
                    city.setIsCapital(true);
                }
            }
        }
    }

    @Override
    public void deleteById(long id) {
        City found = findCityById(id);
        if (found != null) {
            cities.remove(found);
        }
    }

    @Override
    public void deleteByName(String cityNameForDeleting) {
     deleteCityByName(cityNameForDeleting);
    }

    @Override
    public void printAll() {
        for (City city : cities) {
            System.out.println(city);
        }
    }

    private City findCityById(long citylId) {
        for (City city : cities) {
            if (Long.valueOf(citylId).equals(city.getId())) {
                return city;
            }
        }
        return null;
    }

    private void deleteCityByName(String cityNameForDeleting) {
        Iterator<City> iter = cities.iterator();
        while (iter.hasNext()) {
            String cityName = iter.next().getName();
            if (cityName.equals(cityNameForDeleting)) {
                iter.remove();
            }
        }
    }
}
