package ru.job4j.sqlLite;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class StoreSQL extends Config implements AutoCloseable {

    private static final Logger LOG = LogManager.getLogger(StoreSQL.class);

    public Car forResultSet(ResultSet rs) throws SQLException {
        Car car = new Car();
        car.setId(rs.getInt("id"));
        car.setName(rs.getString("name"));
        car.setPower(rs.getInt("power"));
        car.setNumberOfCar(rs.getInt("numberOfCar"));
        car.setDescription(rs.getString("description"));
        return car;
    }

    public void drop() {
        try (Statement statement = getConnection().createStatement()) {
            statement.execute("DROP TABLE cars;  ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void create() {
        try (Statement statement = getConnection().createStatement()) {
            statement.execute("create table if not exists cars(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
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
        for (int i = 1; i < size + 1; i++) {
            Car car = new Car();
            car.setName(String.format("Авто #%d", i));
            car.setPower(i * 2);
            car.setNumberOfCar(i);
            car.setDescription(String.format("Описание к авто #%d", i));
            add(car);
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

    /**
     * Запись данных из БД в List
     *
     * @return
     * @throws SQLException
     */
    public List <Car> addData() throws SQLException {
        List <Car> list = new LinkedList <>();
        try (PreparedStatement statement = this.getConnection().prepareStatement(
                "select * from cars")) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Car car = forResultSet(rs);
                list.add(car);
            }
            LOG.info("Data add to list");
            return list;
        }
    }
}

