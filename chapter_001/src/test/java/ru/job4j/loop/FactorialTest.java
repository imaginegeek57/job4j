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

public class FactorialTest {

    /**
     * Test
     */
    @Test
    public void factorial() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(5);
        assertThat(result, is(120));

    }


    @Test
    public void other() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(-5);
        assertThat(result, is(1));

    }

}