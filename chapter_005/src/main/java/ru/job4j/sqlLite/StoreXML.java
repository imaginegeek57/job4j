package ru.job4j.sqlLite;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public StoreXML() throws SQLException {
        this.addData();
    }

    /**
     * Запись данных из БД в List
     *
     * @return
     * @throws SQLException
     */
    public List <Car> addData() throws SQLException {
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


    public static void convert() throws JAXBException {
        File file = new File("sqlLog.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Car.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        for (Car car : list) {
            jaxbMarshaller.marshal(car, file);
            jaxbMarshaller.marshal(car, System.out);
            LOG.info("Data has converted to xml");
        }

    }

}



