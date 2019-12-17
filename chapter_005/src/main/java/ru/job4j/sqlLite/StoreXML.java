package ru.job4j.sqlLite;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

public class StoreXML {

    private static final Logger LOG = LogManager.getLogger(StoreXML.class);

    public void convert(List <Car> cars) throws JAXBException {
        File file = new File("C:\\projects\\job4j\\chapter_005\\src\\main\\resources\\sqlLog.xml");
        CarList carList = new CarList();
        carList.setCarList(cars);
        JAXBContext jaxbContext = JAXBContext.newInstance(CarList.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(carList, file);
        jaxbMarshaller.marshal(carList, System.out);
        LOG.info("Data has converted to xml");
    }

}



