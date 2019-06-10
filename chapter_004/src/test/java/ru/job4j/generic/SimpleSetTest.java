package ru.job4j.generic;

import org.junit.Test;

import java.util.Iterator;

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
    @Test
    public void useSet2() {
        SimpleSet <Integer> simpleSet = new SimpleSet <Integer>(5);
        simpleSet.add(3);
        simpleSet.add(3);
        simpleSet.add(1);
        simpleSet.add(1);
        Iterator<Integer> it = simpleSet.iterator();
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(false));


    }
}