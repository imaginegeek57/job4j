package ru.job4j.list2;

import org.junit.Test;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class NodeLoopTest {
    private Iterator <Integer> it;

    @Test
    public void setLoops() {

        Node<Integer> a = new Node <>(1);
        Node<Integer> b = new Node <>(2);
        Node<Integer> c = new Node <>(3);
        Node<Integer> d = new Node <>(4);
        Node<Integer> e = new Node <>(5);

        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(b);
        NodeLoop nodeLoop = new NodeLoop();
        boolean b1 = nodeLoop.hasCycle(a);
        assertThat(b1, is(true));
    }
}