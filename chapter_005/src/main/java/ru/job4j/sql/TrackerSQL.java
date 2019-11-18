package ru.job4j.sql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class TrackerSQL implements ITracker, AutoCloseable {

    private static final Logger LOG = LogManager.getLogger(TrackerSQL.class);

    private Connection connection;

    public boolean init() {
        LOG.debug("Initial connection to database");
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );

            try (PreparedStatement statement = this.connection.prepareStatement(
                    "create table item_store (name varchar (10), description varchar (15))")) {
                statement.executeUpdate();
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }


    @Override
    public Item add(Item item) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "insert into item_store (name, description) values (?, ?)")) {
            statement.setString(1, String.valueOf(item));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println(String.format("%s %s", resultSet.getString("name"), resultSet
                        .getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }


    @Override
    public void replace(String id, Item item) {

    }

    @Override
    public void delete(String id) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "delete from item_store where column = id)")) {
            statement.executeUpdate(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List <Item> findAll() {
        return null;
    }

    @Override
    public List <Item> findByName(String key) {
        return null;
    }

    @Override
    public Item findById(String id) {
        return null;
    }

    @Override
    public void close() throws SQLException {
        LOG.debug("Close connection to database");
        this.connection.close();
    }
}
