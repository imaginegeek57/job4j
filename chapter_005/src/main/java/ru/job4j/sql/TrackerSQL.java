package ru.job4j.sql;

import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Item;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TrackerSQL extends SQLManager implements ITracker, AutoCloseable {

    public void create() {
        try (PreparedStatement statement = this.getConnection().prepareStatement(
                "create table if not exists item_store(id serial primary key, " +
                        "name varchar (2000), description varchar (2000)")) {
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Item forResultSet(ResultSet rs) throws SQLException {
        Item item = new Item();
        item.setId(rs.getInt("id"));
        item.setName(rs.getString("name"));
        item.setDescription(rs.getString("description"));
        return item;
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement = this.getConnection().prepareStatement(
                "insert into item_store (name, description) values (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, String.valueOf(item.getName()));
            statement.setString(2, String.valueOf(item.getDescription()));
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                while (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    /**
     * Метод update
     *
     * @param id
     * @param item
     */
    @Override
    public void replace(Integer id, Item item) {
        try (PreparedStatement statement = this.getConnection().prepareStatement(
                "update item_store set name = ?, description = ? where id = ?")) {
            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean delete(Integer id) {
        try (PreparedStatement statement = this.getConnection().prepareStatement(
                "delete from item_store where id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public List <Item> findAll() throws SQLException {
        List <Item> list = new ArrayList <>();
        try (PreparedStatement statement = this.getConnection().prepareStatement(
                "select * from item_store")) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Item item = forResultSet(rs);
                list.add(item);
                System.out.println(list);
            }
            return list;
        }
    }

    @Override
    public List <Item> findByName(String name) {
        List <Item> list = new ArrayList <>();
        try (PreparedStatement statement = this.getConnection().prepareStatement(
                "select from item_store as i where i.name = ?")) {
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Item item = forResultSet(rs);
                list.add(item);
                System.out.println(list);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Item findById(Integer id) {
        Item item = new Item();
        try (PreparedStatement statement = this.getConnection().prepareStatement(
                "select from item_store as i where i.id = ?")) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            item = forResultSet(rs);
            System.out.println(item);
        } catch (SQLException e) {
        }
        return item;
    }

    @Override
    public void close() throws SQLException {
        if (isConnected()) {
            LOG.debug("Close connection to database");
            this.connection.close();
            this.connection = null;
        }
    }
}
