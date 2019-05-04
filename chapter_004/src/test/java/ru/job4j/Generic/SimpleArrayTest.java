package ru.job4j.Generic;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void whenCreateSomething() {
        SimpleArray<String> simple = new SimpleArray(3);
        simple.add("Hi");
        simple.add("to");
        simple.add("anyone");
        String result = simple.get(2);
        assertThat(result, is("anyone"));

    }
    @Test
    public void whenCreateSomethingElse() {
        SimpleArray<String> simple = new SimpleArray(5);
        simple.add("Hi");
        simple.add("to");
        simple.add("anyone");
        simple.add("else");
        simple.remove();
        String result = simple.get(2);
        assertThat(result, is("anyone"));
    }
}