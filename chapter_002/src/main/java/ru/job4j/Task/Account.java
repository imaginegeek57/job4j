package ru.job4j.Task;
import java.util.*;
public class Account {

    double values;       // модифекатор доступа по умолчанию, должен дыть private
    String reqs;
                                     // входящий параметр не верный
    public Account(double values, String requisites) {
        this.values = values;
        this.reqs = requisites;
    }

    public double getValues() { // если переменные public в этом нет смысла
        return this.values;
    }

    public String getReqs () {   // если переменные public в этом нет смысла
        return this.reqs;
    }
                  // усложненная логика
    boolean transfer(Account destination, double amount) {
        boolean success = false;
        if (amount > 0 && amount < this.values && destination != null) {
            success = true;
            this.values -= amount;  // '-'
            destination.values += amount; // '+'
        }
        return success;
    }

    public String toString() {
        String otvet;
        otvet = "Account{" + "values=" + values + ", reqs='" + reqs + "\\" + "}";
        return otvet;
    }

    public boolean equals(Object o) {
        if (this == o) {    // не понятно что сравнивают
            return true;
        }   // не понятно что сравнивают
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;

        return this.reqs.equals(account.reqs);
    }

    public int hashCode() {
        return this.reqs.hashCode();
    }
}