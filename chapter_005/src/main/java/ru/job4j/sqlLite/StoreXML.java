package ru.job4j.sqlLite;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StoreXML extends Config {

    public Car forResultSet(ResultSet rs) throws SQLException {
        Car car = new Car();
        car.setName(rs.getString("name"));
        car.setPower(rs.getInt("power"));
        car.setNumberOfCar(rs.getInt("numberOfCar"));
        car.setDescription(rs.getString("description"));
        return car;
    }

    public List <Car> findAll() throws SQLException {
        List <Car> list = new ArrayList <>();
        try (PreparedStatement statement = this.getConnection().prepareStatement(
                "select * from cars")) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Car car = forResultSet(rs);
                list.add(car);
            }
            return list;
        }
    }


}
