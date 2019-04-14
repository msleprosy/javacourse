package com.epam.javacourse.storage.initor.datasourcereader.sax;

import com.epam.javacourse.country.domain.Country;
import com.epam.javacourse.storage.initor.datasourcereader.XmlParser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.List;

/**
 * Created by veronika on 25.03.2019.
 */

public class CountriesWithCitiesXmlSaxParser implements XmlParser<List<Country>> {
    @Override
    public List<Country> parseFile(String file) throws Exception {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        CountriesWithCitiesXmlSaxHandler handler = new CountriesWithCitiesXmlSaxHandler();
        saxParser.parse(new File(file), handler);

        return handler.getCountries();
    }
}
