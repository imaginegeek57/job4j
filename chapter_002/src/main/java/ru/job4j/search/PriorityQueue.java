package ru.job4j.search;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.LinkedList;
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        LinkedList<Task> pq = new LinkedList <>();
        int count = 0;
        for (Task  put : tasks) {
            if (task.getPriority() < put.getPriority()) {
                break;
            }
            count++;
        }
            pq.add(count, task);
    }
    public Task take() {
        return this.tasks.poll();
    }
}
