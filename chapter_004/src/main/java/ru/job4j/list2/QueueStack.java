package ru.job4j.list2;

import java.util.NoSuchElementException;

public class QueueStack<E> {

    private SimpleStack<E> in;
    private SimpleStack<E> out;
    private int size;

    public QueueStack() {
        this.in = new SimpleStack <>();
        this.out = new SimpleStack <>();
    }

    public void push(E value) {
        this.in.push(value);
        size++;
    }

    public E poll() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.poll());
            }
        }
        E result = null;
        if(!out.isEmpty()) {
            result = out.poll();
            size--;
        }
        return result;
    }

    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
}
