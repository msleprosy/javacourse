package com.epam.javacourse.storage.initor.datasourcereader;

/**
 * Created by veronika on 01.04.2019.
 */
public interface XmlParser<T> {
    T parseFile(String file) throws Exception;
}
