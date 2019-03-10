package com.epam.javacourse.user.repository.implementation;

import com.epam.javacourse.user.domain.User;
import com.epam.javacourse.user.search.UserOrderByField;
import com.epam.javacourse.user.search.UserSearchCondition;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by veronika on 10.03.2019.
 */
public class UserOrderingComponent {
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

    public void applyOrdering(List<User> users, UserSearchCondition userSearchCondition) {
        Comparator<User> userComparator = null;
        UserOrderByField field = userSearchCondition.getOrderByField();
        switch (userSearchCondition.getOrderType()) {

            case SIMPLE: {
                userComparator = UserComparatorComponent.getInstance().getComparatorForField(field);
                break;
            }
            case COMPLEX: {
                userComparator = UserComparatorComponent.getInstance().getComplexComparator(field);
                break;
            }
        }

        if (userComparator != null) {
            switch (userSearchCondition.getOrderDirection()) {

                case ASC:
                    Collections.sort(users, userComparator);
                    break;
                case DESC:
                    Collections.sort(users, userComparator.reversed());
                    break;
            }
        }
    }

}
