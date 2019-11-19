package ru.job4j.sql;

import static org.junit.Assert.*;
import org.junit.Test;
import ru.job4j.tracker.Item;

import static org.hamcrest.Matchers.is;

public class TrackerSQLTest {

    TrackerSQL sql = new TrackerSQL();

    @Test
    public void checkConnection() {
        assertThat(sql.init(), is(true));
        sql.add(new Item("e21", "cdee", "111"));
        sql.add(new Item("232e", "cwewde", "222"));
        sql.add(new Item("5444", "cdeewfr", "333"));
    }

    @Test
    public void checkMethods() {
        sql.replace("111", new Item("Vvv", "fwfdw", "777"));
        sql.delete("222");
    }
}