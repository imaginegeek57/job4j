package ru.job4j.list2;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class ListStore<E> implements Iterable<E>  {

    private Object[] container;
    private int index = 0;

    public ListStore(int size) {
        this.container = new Object[size];
    }
    public int size() {
        return this.index;
    }

    public void add(E value) {
        this.container[index++] = value;
    }

    public E get(int position) {
        return (E) this.container[position];
    }

    public Object[] copy(Object[] container) {
        int copy = container.length;
        for (int i = 0; i < container.length; i++) {
            for (int j = i + 1; j < container.length; j++) {
                if (container[i].equals(container[j])) {
                    container[j] = container[copy + 1];
                    copy++;
                    j++;
                }
            }
        }
        return Arrays.copyOf(container, copy);
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
