package ru.job4j.list2;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class NodeLoopTest {
    private Iterator <Integer> it;

    @Test
    public void setLoops() {

        NodeLoop first = new NodeLoop(1);
        NodeLoop second = new NodeLoop(2);
        NodeLoop third = new NodeLoop(3);
        NodeLoop four = new NodeLoop(4);

        first.iterator().next().equals(second);
        second.iterator().next().equals(third);
        third.iterator().next().equals(four);
        four.iterator().next().equals(first);

        assertThat(first.hasCycle(first), is(false));

    }
}