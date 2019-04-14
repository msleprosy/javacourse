package com.epam.javacourse.storage.initor.datasourcereader;

/**
 * Created by veronika on 20.03.2019.
 */
public interface FileParser<EXTRACTED_DATA> {
    EXTRACTED_DATA parseFile(String file) throws Exception;
}
