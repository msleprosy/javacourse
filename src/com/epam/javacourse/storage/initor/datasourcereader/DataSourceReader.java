package com.epam.javacourse.storage.initor.datasourcereader;

/**
 * Created by veronika on 20.03.2019.
 */
public interface DataSourceReader<EXTRACTED_DATA> {
    EXTRACTED_DATA getDataFromFile(String file) throws Exception;
}
