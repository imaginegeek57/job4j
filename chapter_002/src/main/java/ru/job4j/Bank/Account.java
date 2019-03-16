package ru.job4j.Bank;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.*;
public class Account {
    private String value;
    private int requisites;
    public Account (String value, int requisites) {
        this.value = value;
        this.requisites = requisites;
    }
    public String getValue() {
        return value;
    }
    public int getRequisites() {
        return requisites;
    }
    
}
