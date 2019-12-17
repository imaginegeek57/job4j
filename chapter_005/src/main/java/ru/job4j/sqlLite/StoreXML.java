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

    public static List <Car> list = new LinkedList <>();

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
        list.clear();
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
        File file = new File("C:\\projects\\job4j\\chapter_005\\src\\main\\resources\\sqlLog.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Car.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(list.get(1), file);
        jaxbMarshaller.marshal(list.get(1), System.out);
        LOG.info("Data has converted to xml");
    }

}



