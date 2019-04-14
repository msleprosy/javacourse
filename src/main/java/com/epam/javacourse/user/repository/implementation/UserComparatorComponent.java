package com.epam.javacourse.user.repository.implementation;

import com.epam.javacourse.user.domain.User;
import com.epam.javacourse.user.search.UserOrderByField;

import java.util.*;

import static com.epam.javacourse.common.business.repository.memory.CommonComparatorHolder.getComparatorForNullableStrings;
import static com.epam.javacourse.user.search.UserOrderByField.LASTNAME;
import static com.epam.javacourse.user.search.UserOrderByField.NAME;

/**
 * Created by veronika on 10.03.2019.
 */
public class UserComparatorComponent {
    private static final UserComparatorComponent INSTANCE = new UserComparatorComponent();
    private static Map<UserOrderByField, Comparator<User>> comparatorsByField = new HashMap<>();
    /**
     * For complex comparator only
     */
    private static Set<UserOrderByField> fieldComparePriorityOrder = new LinkedHashSet<>(Arrays.asList(NAME, LASTNAME));

    static {
        comparatorsByField.put(NAME, getComparatorForNameField());
        comparatorsByField.put(LASTNAME, getComparatorForLastNameField());
    }

    private UserComparatorComponent() {
    }


    public static UserComparatorComponent getInstance() {
        return INSTANCE;
    }

    private static Comparator<User> getComparatorForNameField() {
        return new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return getComparatorForNullableStrings().compare(user1.getName(), user2.getName());
            }
        };
    }

    private static Comparator<User> getComparatorForLastNameField() {
        return new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return getComparatorForNullableStrings().compare(user1.getLastName(), user2.getLastName());
            }
        };
    }


    public Comparator<User> getComparatorForField(UserOrderByField field) {
        return comparatorsByField.get(field);
    }

    public Comparator<User> getComplexComparator(UserOrderByField field) {
        return new Comparator<User>() {

            @Override
            public int compare(User u1, User u2) {
                int result = 0;
                Comparator<User> countryComparator = comparatorsByField.get(field);

                if (countryComparator != null) {
                    result = countryComparator.compare(u1, u2);
                    //if records have same order priority, i want to order them in their group
                    if (result == 0) {

                        //loop throug all possible sorting fields
                        for (UserOrderByField otherField : fieldComparePriorityOrder) {
                            //if i haven't sorted by field which is taken from parameter in function, i do sorting
                            if (!otherField.equals(field)) {

                                result = comparatorsByField.get(otherField).compare(u1, u2);
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

