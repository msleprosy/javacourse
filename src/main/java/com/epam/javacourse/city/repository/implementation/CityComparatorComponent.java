package com.epam.javacourse.city.repository.implementation;

import com.epam.javacourse.city.domain.City;
import com.epam.javacourse.city.search.CityOrderByField;

import java.util.*;

import static com.epam.javacourse.city.search.CityOrderByField.IS_CAPITAL;
import static com.epam.javacourse.city.search.CityOrderByField.NAME;
import static com.epam.javacourse.city.search.CityOrderByField.POPULATION;
import static com.epam.javacourse.common.business.repository.memory.CommonComparatorHolder.getComparatorForNullableStrings;

/**
 * Created by veronika on 11.03.2019.
 */
public class CityComparatorComponent {
    private static final CityComparatorComponent INSTANCE = new CityComparatorComponent();
    private static Map<CityOrderByField, Comparator<City>> comparatorsByField = new HashMap<>();
    /**
     * For complex comparator only
     */
    private static Set<CityOrderByField> fieldComparePriorityOrder = new LinkedHashSet<>(Arrays.asList(NAME, POPULATION, IS_CAPITAL));

    static {
        comparatorsByField.put(NAME, getComparatorForNameField());
        comparatorsByField.put(POPULATION, getComparatorForPopulationField());
        comparatorsByField.put(IS_CAPITAL, getComparatorForIsCapitalField());
    }

    private CityComparatorComponent() {
    }


    public static CityComparatorComponent getInstance() {
        return INSTANCE;
    }

    private static Comparator<City> getComparatorForNameField() {
        return new Comparator<City>() {
            @Override
            public int compare(City city1, City city2) {
                return getComparatorForNullableStrings().compare(city1.getName(), city2.getName());
            }
        };
    }

    private static Comparator<City> getComparatorForPopulationField() {
        return new Comparator<City>() {
            @Override
            public int compare(City city1, City city2) {
                String population1 = String.valueOf(city1.getPopulation());
                String population2 = String.valueOf(city2.getPopulation());
                return getComparatorForNullableStrings().compare(population1, population2);
            }
        };
    }

    private static Comparator<City> getComparatorForIsCapitalField() {
        return new Comparator<City>() {
            @Override
            public int compare(City city1, City city2) {
                String isCapital1 = String.valueOf(city1.getIsCapital());
                String isCapital2 = String.valueOf(city2.getIsCapital());
                return getComparatorForNullableStrings().compare(isCapital1, isCapital2);
            }
        };
    }


    public Comparator<City> getComparatorForField(CityOrderByField field) {
        return comparatorsByField.get(field);
    }

    public Comparator<City> getComplexComparator(CityOrderByField field) {
        return new Comparator<City>() {

            @Override
            public int compare(City c1, City c2) {
                int result = 0;
                Comparator<City> cityComparator = comparatorsByField.get(field);

                if (cityComparator != null) {
                    result = cityComparator.compare(c1, c2);
                    //if records have same order priority, i want to order them in their group
                    if (result == 0) {

                        //loop throug all possible sorting fields
                        for (CityOrderByField otherField : fieldComparePriorityOrder) {
                            //if i haven't sorted by field which is taken from parameter in function, i do sorting
                            if (!otherField.equals(field)) {

                                result = comparatorsByField.get(otherField).compare(c1, c2);
                                //if sort result detected that records are not equals - we exit from loop,
                                //else continue
                                if (result != 0) {
                                    break;
                                }
                            }
                        }

                    }
                }
                return result;
            }
        };
    }
}
