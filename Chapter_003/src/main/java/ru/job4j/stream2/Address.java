package ru.job4j.stream2;


public class Address {
    private String city;
    private String street;
    private  int home;
    private int apartment;
    Address (String city, String street, int home, int apartment) {
        this.city = city;
        this.apartment = apartment;
        this.street = street;
        this.home = home;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public int getHome() {
        return home;
    }
    public void setHome(int home) {
        this.home = home;
    }
    public int getApartment() {
        return apartment;
    }
    public void setApartment(int apartment) {
        this.apartment = apartment;
    }
}
