package ru.job4j.lambda;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.*;
import java.util.function.Function;
public class Lmd {
    public List <Double> diapason(int start, int end, Function <Double, Double> func) {// передаём от и до и функцию(еще не знаем что она будет делать)
        final List <Double> list = new ArrayList <>(); // лист для результата
        for (int index = start; index != end; index++) { // цикл
            list.add(func.apply((double) index)); //добавляем в лист то что получится при применении функции к индексу
        }
        return list; // возвращаем лист
    }
}
