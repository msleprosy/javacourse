package com.epam.javacourse.common.business.application;

/**
 * Created by veronika on 04.03.2019.
 */
public class SequenceGenerator {
    volatile static int idGenerator = 0;
    public synchronized int generateId(){
        return idGenerator++;
    }
}
