package ru.job4j.sql;

import static org.junit.Assert.*;
import org.junit.Test;
import ru.job4j.tracker.Item;

import java.sql.SQLException;

import static org.hamcrest.Matchers.is;

public class TrackerSQLTest {

    TrackerSQL sql = new TrackerSQL();

    @Test
    public void checkConnection() {
        assertThat(sql.init(), is(true));
        sql.add(new Item(12, "e4de", "idke"));
        sql.add(new Item(3, "ed6", "id54ke"));
        sql.add(new Item(8, "ed3e", "f3idke"));

    }

    @Test
    public void checkMethods() throws SQLException {
        sql.replace(8, new Item(2, "edeew", "idkwre"));
        sql.delete(3);
        //   sql.findAll();
    }
}