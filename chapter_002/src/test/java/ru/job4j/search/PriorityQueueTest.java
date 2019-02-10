package ru.job4j.search;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }
    @Test
    public void name() {
        PriorityQueue pq = new PriorityQueue();
        pq.put(new Task("l", 8));
        pq.put(new Task("u", 3));
        pq.put(new Task("m", 5));
        assertThat(pq.take().getPriority(), is(3));
    }
}
