package ru.job4j.list2;

import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class listNodeTest {
    private listNode<Integer> node;
    private Iterator<Integer> it;

    @Before
    public void addIntoStore() {
        node = new listNode <>();
        node.add(0);
        node.add(1);
        node.add(2);
        node.add(3);
        node.add(4);
        node.add(5);
        it = node.iterator();
    }
    @Test
    public void whenUseNode() {
        Integer result = node.get(3);
        assertThat(result, is(2));
        assertThat(node.getSize(), is(6));
    }
    @Test
    public void whenUseNext() {
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(0));
        assertThat(it.hasNext(), is(false));
    }
}