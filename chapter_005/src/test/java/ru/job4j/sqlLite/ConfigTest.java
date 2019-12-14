package ru.job4j.sqlLite;

import org.junit.Test;

import javax.xml.bind.JAXBException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConfigTest {
    Config config = new Config();
    StoreSQL storeSQL = new StoreSQL();


    @Test
    public void connect() {
        assertThat(config.getConnection(), is(true));

    }


    @Test
    public void convertToXML() throws JAXBException {
        storeSQL.create();
        storeSQL.generate();
        StoreXML.convert();
    }
}
