package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.List;

public interface ITracker {
    Item add(Item item);

    void replace(Integer id, Item item);

    boolean delete(Integer id);

    List <Item> findAll() throws SQLException;

    List <Item> findByName(String name);

    Item findById(Integer id);
}
