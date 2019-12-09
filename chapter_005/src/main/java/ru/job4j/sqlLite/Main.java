package ru.job4j.sqlLite;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class Main extends StoreXML {


    public static void main(String[] args) throws JAXBException {

        try {

            File file = new File("sqlLog.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Car.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(list.get(0), file);
            jaxbMarshaller.marshal(list.get(0), System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}

