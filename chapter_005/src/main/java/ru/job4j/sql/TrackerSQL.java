package ru.job4j.sql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TrackerSQL implements ITracker, AutoCloseable {

    private static final Logger LOG = LogManager.getLogger(TrackerSQL.class);

    private static final String PROPERTIES_FILE = "app.properties";

    /* Параметры для подключения */

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    private Connection connection;

    public TrackerSQL() {
        this.readFileProperties(PROPERTIES_FILE);
    }

    private void readFileProperties(String fileName) {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream(fileName)) {
            Properties config = new Properties();
            config.load(in);

            this.driverClassName = config.getProperty("driver-class-name");
            this.url = config.getProperty("url");
            this.username = config.getProperty("username");
            this.password = config.getProperty("password");

        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public void connect() {
        LOG.debug("Connect to database");
        try {
            Class.forName(this.driverClassName);
            this.connection = DriverManager.getConnection(this.url, this.username, this.password);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public boolean isConnected() {
        return connection != null;
    }

    private Connection getConnection() {
        if (!isConnected()) {
            connect();
        }
        return connection;
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
            ResultSet generatedKeys = statement.getGeneratedKeys();
            while (generatedKeys.next()) {
            }
            statement.executeUpdate();
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
     * @return
     */
    @Override
    public void replace(Integer id, Item item) {
        try (PreparedStatement statement = this.getConnection().prepareStatement(
                "update item_store set (name = ?, description = ?) where id = ?")) {
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
                "delete from item_store where column = id)")) {
            statement.setInt(1, id);
            int i = statement.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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
            }
            return list;
        }
    }

    @Override
    public boolean findByName(String name) {
        try (PreparedStatement statement = this.getConnection().prepareStatement(
                "select from item_store where column = name)")) {
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            int i = statement.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {

        }
        return false;
    }

    @Override
    public boolean findById(Integer id) {
        try (PreparedStatement statement = this.getConnection().prepareStatement(
                "select from item_store where column = id)")) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            int i = statement.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {

        }
        return false;
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
