package ru.job4j.sqlLite;

import org.junit.Test;

import javax.xml.bind.JAXBException;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConfigTest {
    Config config = new Config();
    StoreSQL storeSQL = new StoreSQL();
    StoreXML storeXML = new StoreXML();

    public ConfigTest() throws SQLException {
    }

    @Test
    public void connect() {
        assertThat(config.getConnection(), is(true));

    }


    @Test
    public void convertToXML() throws SQLException, JAXBException {
        storeSQL.drop();
        storeSQL.generate(2);
        storeXML.addData();
        StoreXML.convert();
    }
}
