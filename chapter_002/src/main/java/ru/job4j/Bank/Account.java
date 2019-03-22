package ru.job4j.Bank;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.*;
public class Account {
    private double value;
    private int requisites;
    public Account (double value, int requisites) {
        this.value = value;
        this.requisites = requisites;
    }
    public double getValue() {
        return value;
    }
    public int getRequisites() {
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
}


