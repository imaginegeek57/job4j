package ru.job4j.list2;

import java.util.*;
import java.util.function.Consumer;

public class ListStore<E> implements Iterable<E>  {

    private Object[] container;
    private int index = 0;

    public int size() {
        return this.index;
    }

    public void add(E value) {
        this.container[index++] = value;
    }

    public E get(int position) {
        return (E) this.container[position];
    }

    public void copy () {
        int[] copy = new int[] {container.length};
        int[] newCopy = Arrays.copyOf(copy, copy.length * 2);
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
