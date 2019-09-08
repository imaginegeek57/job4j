package ru.job4j.bankStream;

import java.util.Objects;

public class Account {
    private double value;
    private String requisites;

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }
    public double getValue() {
        return value;
    }
    public String getRequisites() {
        return requisites;
    }

    boolean transfer(Account destination, double amount) {
        boolean success = false;
        if (amount > 0 && amount < this.value && destination != null) {
            success = true;
            this.value -= amount;
            destination.value += amount;
        }
        return success;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(account.value, value) == 0 &&
                Objects.equals(requisites, account.requisites);
    }
    @Override
    public int hashCode() {
        return Objects.hash(value, requisites);
    }
}

