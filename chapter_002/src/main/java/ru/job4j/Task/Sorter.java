package ru.job4j.Task;
import java.util.*;
public class Sorter {

    public Sorter(){     // конструктор по умолчанию писать нет смысла
    }

    Set<User> sort (List<User> list) {            // название метода не соответствует действид
        TreeSet<User> sortedList = new TreeSet<>();
        sortedList.addAll(list);
        return sortedList;
    }
    List<User> sortnamelength (List<User> list) {
        Comparator<User> compar = new Comparator<User>() {    // Структура данных Comparator не верно
            @Override   //
            public int compare (User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        };
        list.sort(compar);  // пишется перед override
        return list;
    }

    List<User> sortboth (List<User> list) {    // усложненная логика, много кода, 2 метода сортировки вместо 1
        Comparator<User> compar1 = new Comparator<User>() {  // Структура данных Comparator не верно
            @Override
            public int compare (User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Comparator<User> compar2 = new Comparator<User>() { // Структура данных Comparator не верно
            @Override
            public int compare (User o1, User o2) {
                return o1.getAge() - o2.getAge();
            }
        };
        // первым указываем массив
        list.sort(compar1.thenComparing(compar2));
        return list;
    }
}

