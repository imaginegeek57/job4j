package ru.job4j.sqlLite;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UTFDataFormatException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StoreXML extends Config {

    protected static List <Car> list = new LinkedList <>();

    public Car forResultSet(ResultSet rs) throws SQLException {
        Car car = new Car();
        car.setName(rs.getString("name"));
        car.setPower(rs.getInt("power"));
        car.setNumberOfCar(rs.getInt("numberOfCar"));
        car.setDescription(rs.getString("description"));
        return car;
    }

    /**
     * Запись данных из БД в List
     *
     * @return
     * @throws SQLException
     */
    public List <Car> findAll() throws SQLException {
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
