package ru.job4j.list2;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class listNodeTest {

    @Test
    public void whenWeTry() {
        listNode <String> node = new listNode <>();
        node.add("Hi");
        node.add("A1");
        node.add("A2");
        node.add("A3");
        node.add("A4");
        node.add("A5");
        String result = node.get(3);
        assertThat(result, is("A2"));
        assertThat(node.getSize(), is(6));
    }
}