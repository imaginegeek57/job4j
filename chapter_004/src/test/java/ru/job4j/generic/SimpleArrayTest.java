package ru.job4j.generic;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void whenCreateSomething() {
        SimpleArray<String> simple = new SimpleArray(10);
        simple.add("Hi");
        simple.add("to");
        simple.add("anyone");
        simple.add("else");
        simple.add("123");
        simple.remove(2);
        String result = simple.get(2);
        assertThat(result, is("else"));
    }

    @Test
    public void whenCreateSomethingElse() {
        SimpleArray<Integer> simple = new SimpleArray(10);
        simple.add(3);
        simple.add(7);
        simple.add(12);
        simple.set(1, 8);
        Integer result = simple.get(1);
        assertThat(result, is(8));
    }
}