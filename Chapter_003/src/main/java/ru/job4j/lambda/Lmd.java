package ru.job4j.lambda;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.*;
import java.util.function.Function;
public class Lmd {
    public interface Operation {
        double calc(int left, int right);
    }

    public List <Double> diapason(int start, int end, int value,
                                  Function <Double, Double> func) { // func это функция calc(int left, int right) верно?
        for (int index = start; index != end; index++) {

        Operation lambda = (left, right) -> {}
    }
}

