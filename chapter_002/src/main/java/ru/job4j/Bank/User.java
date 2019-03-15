package ru.job4j.Bank;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.Objects;
public class User {
    private String name;
    private int passport;
    public User(String name, int passport) {
        this.name = name;
        this.passport = passport;
    }
    public String getName() {
        return this.name;
    }
    public int getPassport() {
        return passport;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return passport == user.passport &&
                Objects.equals(name, user.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }
}

