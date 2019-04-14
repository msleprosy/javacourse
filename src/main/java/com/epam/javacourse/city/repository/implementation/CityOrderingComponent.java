package com.epam.javacourse.city.repository.implementation;

import com.epam.javacourse.city.domain.City;
import com.epam.javacourse.city.search.CityOrderByField;
import com.epam.javacourse.city.search.CitySearchCondition;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by veronika on 11.03.2019.
 */
public class CityOrderingComponent {
    class MyComparable implements Comparable<String> {

        private String srcString;
        private boolean invert = false;

        public MyComparable(String srcString) {
            this.srcString = srcString;
        }

        @Override
        public int compareTo(String o) {
            if (invert) {
                return (-1) * this.srcString.compareTo(o);
            } else {
                return this.srcString.compareTo(o);
            }
        }
    }

    public void applyOrdering(List<City> cities, CitySearchCondition citySearchCondition) {
        Comparator<City> userComparator = null;
        CityOrderByField field = citySearchCondition.getOrderByField();
        switch (citySearchCondition.getOrderType()) {

            case SIMPLE: {
                userComparator = CityComparatorComponent.getInstance().getComparatorForField(field);
                break;
            }
            case COMPLEX: {
                userComparator = CityComparatorComponent.getInstance().getComplexComparator(field);
                break;
            }
        }

        if (userComparator != null) {
            switch (citySearchCondition.getOrderDirection()) {

                case ASC:
                    Collections.sort(cities, userComparator);
                    break;
                case DESC:
                    Collections.sort(cities, userComparator.reversed());
                    break;
            }
        }
    }
}
