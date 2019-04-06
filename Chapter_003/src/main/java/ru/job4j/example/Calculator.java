package ru.job4j.example;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
public class Calculator {
    public interface Operation {
        double calc(int left, int right);
    }
    public void multiple(int start, int finish, int value,
                         BiFunction <Integer, Integer, Double> op, // op -это конструктор интерфейса Operation?
                         Consumer <Double> media) { // для чего мы это используем?
        for (int index = start; index != finish; index++) {
            media.accept(op.apply(value, index)); // media.accept(op.apply - что обозначают эти слова не совсем понятно
        }

    }
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.multiple(
                0, 10, 2,
                (value, index) -> {
                    double result = value * index;
                    System.out.printf("Multiple %s * %s = %s %n", value, index, result);
                    return result;
                },
                result -> System.out.println(result)
        );
    }
}
