package ru.job4j.Task;

public class User {
    public Account getAccount() {
        return account;
    }

    private Account account;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int age;
    private String name;

    public void setAccount(Account account) {
        this.account = account;
    }
}
