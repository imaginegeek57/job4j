package ru.job4j.search;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.ArrayList;
import java.util.List;
public class PhoneDictionary {
    private List <Person> persons = new ArrayList <Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */

    public List <Person> find(String key) {
        List <Person> result = new ArrayList <>();
        for (Person person  : persons) {
            if (persons.contains(key)) {
            }
        }
        return result;
    }
}
