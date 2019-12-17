package ru.job4j.sql;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import org.hamcrest.core.Is;
import org.junit.Test;
import ru.job4j.tracker.Item;

import java.sql.SQLException;

import static org.hamcrest.Matchers.is;

public class TrackerSQLTest {

    TrackerSQL sql = new TrackerSQL();

    @Test
    public void checkConnection() {
        sql.add(new Item(12, "e4de", "idke"));
        sql.add(new Item(3, "ed6", "id54ke"));
        sql.add(new Item(8, "ed3e", "f3idke"));

    }


    @Test
    public void checkMethods1() {
        SQLManager sm = new SQLManager();
        assertThat(sm.getConnection(), is(true));

    }

    @Test
    public void checkMethods() throws SQLException {
        sql.create();
        //  sql.findAll();
        //    sql.replace(10, new Item("111UUUU", "111FFGT"));
        // sql.delete(2);
        //     sql.findAll();
        //   sql.findById(10);
        //    sql.findByName("333");
        sql.close();
    }
}