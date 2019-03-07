package ru.job4j.collection;

import java.util.Comparator;

/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class User {
    private String name;
    private int age;
    public User (String name, int age) {
        this.name = name;
        this.age =age;
    }
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
}
class UserAge implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        int comp = o1.getName().compareTo(o2.getName());
        return comp !=0 ? comp : Integer.compare(o1.getAge(),o2.getAge());
    }
}

