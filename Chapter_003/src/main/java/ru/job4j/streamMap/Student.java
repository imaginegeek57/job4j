package ru.job4j.streamMap;

import java.util.Objects;

public class Student {
    private String surname;
    private String name;
    private int score;
    public Student(int score, String surname, String name) {
        this.score = score;
        this.surname = surname;
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getScore() {
        return score;
    }
    Student(int score) {
        this.score = score;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return surname == student.surname;
    }
    @Override
    public int hashCode() {
        return Objects.hash(surname);
    }
}
