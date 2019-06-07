package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void useSet() {
        SimpleSet<String> simpleSet = new SimpleSet <String>(5);
        simpleSet.add("Hi");
        simpleSet.add("Hi");
        simpleSet.add("Hi");
        simpleSet.add("1");
        simpleSet.add("2");
        assertThat(simpleSet.size(), is (3));
    }
}