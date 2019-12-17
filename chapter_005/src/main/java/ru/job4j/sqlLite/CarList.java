package ru.job4j.sqlLite;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.List;

import static javax.xml.bind.annotation.XmlAccessType.FIELD;

@XmlRootElement(name = "Cars")
@XmlAccessorType(FIELD)
public class CarList {

    @XmlElement
    private List <Car> carList;

    public List <Car> getCarList() {
        return carList;
    }

    public void setCarList(List <Car> carList) {
        this.carList = carList;
    }
}
