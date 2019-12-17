package ru.job4j.sqlLite;

import java.security.KeyStore;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StoreSQL extends Config implements AutoCloseable {

    public void drop() {
        try (Statement statement = getConnection().createStatement()) {
            statement.execute("DROP TABLE cars;  ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
                    car.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    public void generate(int size) {
        create();
//        add(new Car(1, "aa", 12, 124, "AAA"));
//        add(new Car(2, "bb", 13, 125, "BBB"));
//        add(new Car(3, "cc", 14, 126, "CCC"));
//        add(new Car(4, "dd", 15, 127, "DDD"));
//        add(new Car(5, "ee", 16, 128, "EEE"));
        try (PreparedStatement statement = this.getConnection().prepareStatement(
                "insert into cars(id, name, power, numberOfCar, description) values (?, ?, ?, ?, ?)")) {
            this.getConnection().setAutoCommit(false);
            for (int i = 1; i < size + 1; i++) {
                statement.setInt(1, i);
                statement.setString(2, String.valueOf(i));
                statement.setInt(3, i);
                statement.setInt(4, i);
                statement.setString(5, String.valueOf(i));
                statement.addBatch();
            }
            statement.executeBatch();
            this.getConnection().setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List <Car> load() {
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

