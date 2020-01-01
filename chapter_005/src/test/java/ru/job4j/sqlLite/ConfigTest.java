package ru.job4j.sqlLite;

import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.sql.SQLException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConfigTest {
    Config config = new Config();
    StoreSQL storeSQL = new StoreSQL();
    StoreXML storeXML = new StoreXML();

    @Test
    public void convertToXML() throws SQLException, JAXBException {
        storeSQL.drop();
        storeSQL.generate(3);
        storeXML.convert(storeSQL.addData());
    }
}
