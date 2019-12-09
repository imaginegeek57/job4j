package ru.job4j.sqlLite;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Car")
public class Car {

    private int id;

    private String name;
    private int power;
    private int numberOfCar;
    private String description;

    public Car(int id, String name, int power, int numberOfCar, String description) {
        this.id = id;
        this.name = name;
        this.power = power;
        this.numberOfCar = numberOfCar;
        this.description = description;
    }

    public Car() {
    }

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    @XmlElement
    public void setPower(int power) {
        this.power = power;
    }

    public int getNumberOfCar() {
        return numberOfCar;
    }

    @XmlElement
    public void setNumberOfCar(int numberOfCar) {
        this.numberOfCar = numberOfCar;
    }

    public String getDescription() {
        return description;
    }

    @XmlElement
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", numberOfCar=" + numberOfCar +
                ", description='" + description + '\'' +
                '}';
    }
}
