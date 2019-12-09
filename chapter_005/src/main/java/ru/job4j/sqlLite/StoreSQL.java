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
                "insert into cars(id, name, power, numberOfCar, description) values (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, car.getId());
            statement.setString(2, car.getName());
            statement.setInt(3, car.getPower());
            statement.setInt(4, car.getNumberOfCar());
            statement.setString(5, car.getDescription());
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
        create();
        add(new Car(1, "aa", 12, 124, "AAA"));
        add(new Car(2, "bb", 13, 125, "BBB"));
        add(new Car(3, "cc", 14, 126, "CCC"));
        add(new Car(4, "dd", 15, 127, "DDD"));
        add(new Car(5, "ee", 16, 128, "EEE"));
        LOG.info("add data");

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

    public static void main(String[] args) {
    }

}

