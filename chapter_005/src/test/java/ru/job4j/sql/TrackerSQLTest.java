package ru.job4j.sql;

import static org.junit.Assert.*;
import org.junit.Test;
import ru.job4j.tracker.Item;

import static org.hamcrest.Matchers.is;

public class TrackerSQLTest {
    @Test
    public void checkConnection() {
        TrackerSQL sql = new TrackerSQL();
        assertThat(sql.init(), is(true));
        sql.add(new Item("1", "cde"));
        sql.add(new Item("2", "cde"));
        sql.add(new Item("5", "cde"));
    }
}