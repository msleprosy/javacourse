package com.epam.javacourse.common.business.repository.memory;

import java.util.Comparator;

/**
 * Created by veronika on 10.03.2019.
 */
public class CommonComparatorHolder {
    private static final CommonComparatorHolder INSTANCE = new CommonComparatorHolder();

    private static Comparator<String> comparatorForNullableStrings = new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {

            if (s1 == null && s2 == null){
                return 0;
            }else if (s1!=null){
                return s1.compareTo(s2);
            }else {
                return -1;
            }

        }
    };

    private CommonComparatorHolder(){

    }

    public static Comparator<String> getComparatorForNullableStrings(){
        return comparatorForNullableStrings;
    }
}
