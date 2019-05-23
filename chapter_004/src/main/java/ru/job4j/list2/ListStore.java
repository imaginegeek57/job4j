package ru.job4j.list2;

import java.util.*;
import java.util.function.Consumer;

public class ListStore<E> implements Iterable<E>  {

    private Object[] container;
    private int index = 0;

    public ListStore(Object[] container) {
        this.container = container;
    }
    public void add(E value) {
        if (index == container.length) {
            copy();
        }
        container[index++] = value;
    }

    public E get(int position) {
        return (E) this.container[position];
    }

    public void copy () {
        this.container = Arrays.copyOf(container,container.length * 2);
    }
    public Iterator <E> iterator() {
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
