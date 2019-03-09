package ru.job4j.collection;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
        import java.util.*;
public class SortUser {
    public Set <User> sort(List <User> user) {
        Set <User> users = new TreeSet <>();
        return new TreeSet <>(user);
    }
    public Set <User> sortName(List <User> user) {
        user.sort(new Comparator <User>() {  // используем comparator что бы указать правила сортировки -
            @Override                         // обьектов (user) в коллекции
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());   // сравниваем два обьекта o1 b o2 по имени
            }                                                 // и сортеруем их
        });
        return (Set <User>) user;
    }
}

