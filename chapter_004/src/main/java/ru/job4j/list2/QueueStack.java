package ru.job4j.list2;

import java.util.NoSuchElementException;

public class QueueStack<E> {

    private ListNode<E> stack;

    QueueStack() {
        this.stack = new ListNode <>();
    }

    public void push(E value) {
        this.stack.add(value);
    }
    public E poll() {
        if (this.stack.getSize() == 0) {
            throw new NoSuchElementException();
        }
       // E result =
        return result;
    }
}
