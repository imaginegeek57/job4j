package ru.job4j.list2;

import java.util.*;
import java.util.function.Consumer;


public class ListStore<E> implements Iterable<E>  {

    private Object[] container;
    private int index = 0;
    private int size = 0;

    public ListStore(Object[] container) {
        this.container = container;

    }
    public ListStore(int size) {
        this.size = size;
        this.container = new Object[size];
    }
    public void add(E value) {
        this.container[index++] = value;
    }

    public E get(int position) {
        return (E) this.container[position];
    }

    public void copy () {
        if (size == container.length) {
        resize(container.length * 2);
        }
    }
    public void resize (int capacity) {
        Object[] copy = new Object[capacity];
        for (int i = 0; i < container.length; i++) {
            copy[i] = container[i];
            container = copy;
        }
    }

    public Iterator <E> iterator() {
//        if (modCount != expectedModCount)
//            throw new ConcurrentModificationException();
        return new Iterator <E>() {
            int str;
            @Override
            public boolean hasNext() {
                return str < index;
            }
            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[str++];
            }
        };
    }
}
