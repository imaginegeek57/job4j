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
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }


    @Override
    public Item add(Item item) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "insert into item_store (name, description) values (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, String.valueOf(item));
            statement.setString(2, String.valueOf(item));
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            while (generatedKeys.next()) {
                System.out.println(generatedKeys.getInt(1));
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
    public void replace(String id, Item item) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "update item_store set (id, name, description) where id=?")) {
            statement.setString(1, String.valueOf(item));
            statement.setString(2, String.valueOf(item));
            statement.setString(3, String.valueOf(item));
            statement.setString(4, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
