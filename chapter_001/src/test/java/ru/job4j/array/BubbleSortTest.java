package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class BubbleSortTest {

        @Test
        public void whenIable() {
            BubbleSort bubbleSort = new BubbleSort();
            int[] input = new int[] {4, 1, 6, 2};
            int[] result = bubbleSort.sort(input);
            int[] expect = new int[] {1, 2, 4, 6};
            assertThat(result, is(expect));
        }

    }

