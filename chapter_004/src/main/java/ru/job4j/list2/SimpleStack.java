package ru.job4j.list2;

import java.util.NoSuchElementException;

public class SimpleStack<E>  {

    private ListNode <E> node;
    private int size = 0;

    public SimpleStack() {
        this.node = new ListNode <>();
    }
    public int size() {
        return this.size;
    }

    public void push(E value) {
        this.node.add(value);
        size++;
    }

    public E poll() {
        if (this.node.getSize() == 0) {
            throw new NoSuchElementException();
        }
        E result = this.node.delete();
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
