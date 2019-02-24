package com.epam.javacourse.city.repository;

import com.epam.javacourse.city.City;

import static com.epam.javacourse.memory.Memory.cities;

public class CityMemoryRepository implements CityRepository{

    public void addCity(City city) {
        cities.add(city);
    }

    public void deleteCity(City city) {
        String foundName = findCityNameByEntity(city);
        if (foundName != null) {
            deleteCityByName(foundName);
        }
    }

    public void updateCityName(String currentCityName, String newCityName){
        for (City city : cities) {
            if (city.getName().equals(currentCityName)) {
                city.setName(newCityName);
            }
        }
    }

    public void updateCityPopulation(String cityName, int currentCityPopulation, int newCityPopulation){
        for (City city : cities) {
            if (city.getName().equals(cityName)) {
                if (city.getPopulation() == currentCityPopulation) {
                    city.setPopulation(newCityPopulation);
                }
            }
        }
    }

    public void updateTheCapitalMark(String cityName){
        for (City city : cities) {
            if (city.getName().equals(cityName)){
                if (city.getIsCapital() == true) {
                    city.setIsCapital(false);
                } else {
                    city.setIsCapital(true);
                }
            }
        }
    }

    public void printCities() {
        for (City city : cities) {
            System.out.println(city);
        }
    }

    private String findCityNameByEntity(City cityEntity) {
        for(City city : cities) {
            if (city.equals(cityEntity)) {
                return city.getName();
            }
        }
        return null;
    }

    private void deleteCityByName(String cityName) {
        for (City city : cities) {
            if (city.getName().equals(cityName)) {
                cities.remove(city);
            }
        }
    }

}
