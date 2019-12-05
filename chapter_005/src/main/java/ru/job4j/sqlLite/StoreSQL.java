package ru.job4j.sqlLite;

import java.security.KeyStore;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;

public class StoreSQL extends Config implements AutoCloseable {

    public void create() {
        try (Statement statement = getConnection().createStatement()) {
            statement.execute("create table if not exists cars(id serial primary key, " +
                    "name varchar (2000), power integer, numberOfCar integer,  description varchar (2000))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Car add(Car car) {
        try (PreparedStatement statement = this.getConnection().prepareStatement(
                "insert into cars(name, power, numberOfCar, description) values (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, car.getName());
            statement.setInt(2, car.getPower());
            statement.setInt(3, car.getNumberOfCar());
            statement.setString(4, car.getDescription());
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                while (generatedKeys.next()) {
                    generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    public void generate(int size) {

    }

    public List <KeyStore.Entry> load() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public void close() throws Exception {
        if (isConnected()) {
            LOG.debug("Close connection to database");
            this.connection.close();
            this.connection = null;
        }
    }

}

