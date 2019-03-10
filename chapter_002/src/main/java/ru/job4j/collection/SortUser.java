package ru.job4j.collection;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.*;
public class SortUser {
    private static final Object List = ;

    public Set <User> sort(List <User> user) {
        Set <User> users = new TreeSet <>();
        return (Set <User>) user;
    }
    public Set <User> sortName(List <User> user) {
        user.sort(new Comparator <User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }                           //  еще вариант Integer.compare(o1.length(), o2.length())
        });
        return (Set <User>) user;
    }
    public Set <User> sortAll(List <User> user) {
        user.sort(new Comparator <User>() {
            @Override
            public int compare(User o1, User o2) {
                int comp = o1.getName().compareTo(o2.getName());
                return comp != 0 ? comp : Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        return (Set <User>) user;
    }
}

