package ru.job4j.list2;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ListStoreTest {

    @Test
    public void whenSomeThing() {
        ListStore<String> list = new ListStore <>(10);
       list.add("Hi");
       list.add("j1");
       list.add("j2");
       list.add("j3");
       list.add("j4");
       list.add("j5");
       list.add("j6");
       list.add("j7");
       list.add("j8");
       list.add("j9");
       list.add("j10");
       list.add("j11");
       list.add("j12");
       list.add("j13");
       list.add("j14");
        assertThat(list.get(13), is("j13"));
        assertThat(list.size(), is(15));
    }
}