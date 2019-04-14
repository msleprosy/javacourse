package com.epam.javacourse.storage.initor.datasourcereader;

import com.epam.javacourse.common.solutions.xml.stax.XmlStaxUtils;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;

/**
 * Created by veronika on 25.03.2019.
 */

    public class StaxReader implements AutoCloseable {
        private XMLStreamReader reader;

        private StaxReader(){
        }

        public static StaxReader getStaxReader(InputStream inputStream) throws XMLStreamException {
            StaxReader staxReader = new StaxReader();
            staxReader.reader = XmlStaxUtils.getReader(inputStream);
            return staxReader;
        }

        @Override
        public void close() throws Exception {
            if (reader != null) {
                reader.close();
            }
        }

        public XMLStreamReader getReader() {
            return reader;
        }

    }

