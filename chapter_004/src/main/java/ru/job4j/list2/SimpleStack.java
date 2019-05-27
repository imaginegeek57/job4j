package ru.job4j.list2;

import java.util.NoSuchElementException;

public class SimpleStack<E>  {

    private ListNode <E> node;

    public SimpleStack(ListNode <E> node) {
        this.node = node;
    }

    public void push(E value) {
        this.node.add(value);
    }

    public E poll() {
        if (this.node.getSize() == 0) {
            throw new NoSuchElementException();
        }
        E result = node;
        return result;
    }
}
