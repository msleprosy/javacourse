package com.epam.javacourse.country.repository.implementation;

import com.epam.javacourse.country.domain.Country;
import com.epam.javacourse.country.search.CountryOrderByField;

import java.util.*;

import static com.epam.javacourse.common.business.repository.memory.CommonComparatorHolder.getComparatorForNullableStrings;
import static com.epam.javacourse.country.search.CountryOrderByField.NAME;

/**
 * Created by veronika on 10.03.2019.
 */
public class CountryComparatorComponent {
    private static final CountryComparatorComponent INSTANCE = new CountryComparatorComponent();
    private static Map<CountryOrderByField, Comparator<Country>> comparatorsByField = new HashMap<>();
    /**
     * For complex comparator only
     */
    private static Set<CountryOrderByField> fieldComparePriorityOrder = new LinkedHashSet<>(Arrays.asList(NAME));

    static {
        comparatorsByField.put(NAME, getComparatorForNameField());
    }

    private CountryComparatorComponent() {
    }


    public static CountryComparatorComponent getInstance() {
        return INSTANCE;
    }

    private static Comparator<Country> getComparatorForNameField() {
        return new Comparator<Country>() {
            @Override
            public int compare(Country country1, Country country2) {
                return getComparatorForNullableStrings().compare(country1.getName(), country2.getName());
            }
        };
    }

    public Comparator<Country> getComparatorForField(CountryOrderByField field) {
        return comparatorsByField.get(field);
    }

    public Comparator<Country> getComplexComparator(CountryOrderByField field) {
        return new Comparator<Country>() {

            @Override
            public int compare(Country c1, Country c2) {
                int result = 0;
                Comparator<Country> countryComparator = comparatorsByField.get(field);

                if (countryComparator != null) {
                    result = countryComparator.compare(c1, c2);
                    //if records have same order priority, i want to order them in their group
                    if (result == 0) {

                        //loop throug all possible sorting fields
                        for (CountryOrderByField otherField : fieldComparePriorityOrder) {
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
