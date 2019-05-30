package ru.job4j.list2;

import java.util.NoSuchElementException;

public class QueueStack<E> {

    private SimpleStack<E> in = new SimpleStack <>();
    private SimpleStack<E> out = new SimpleStack <>();
    private int size;


    public void push(E value) {
        this.in.push(value);
    }

    public E poll() {
        if (out.isEmpty())
            while (!in.isEmpty())
                out.push(in.poll());
        E temp = null;
        if (!out.isEmpty()) {
            temp = out.poll();
            size--;
        }
        return temp;
    }

    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
}
