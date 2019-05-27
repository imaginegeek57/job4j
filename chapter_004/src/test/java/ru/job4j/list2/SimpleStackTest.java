package ru.job4j.list2;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleStackTest {
    @Test
    public void whenSomeThing() {
        SimpleStack<String> ss = new SimpleStack <>();
        ss.push("A0");
        ss.push("A1");
        ss.push("A2");
        ss.push("A3");
        assertThat(ss.poll(), is ("A3"));
        assertThat(ss.poll(), is ("A2"));
        assertThat(ss.poll(), is ("A1"));
        assertThat(ss.poll(), is ("A0"));
    }
}