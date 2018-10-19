package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class CounterTest {
    /**
     * Test
     */
    @Test
    public void count() {
        Counter counter = new Counter();
        int result = counter.count(0, 10);
        assertThat(result, is(30));

    }

}
