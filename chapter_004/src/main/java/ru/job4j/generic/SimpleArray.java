package ru.job4j.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] objects;
    private int index = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public int size() {
        return this.index;
    }
    public void add(T model) {
        this.objects[index++] = model;
    }

    public boolean set(int index, T model) {
        if (index > -1 && index > this.index) {
            throw new IndexOutOfBoundsException();
        }
        this.objects[index] = model;
        return true;
    }

    public T get(int position) {
        return (T) this.objects[position];
    }

    public T remove(int index) {
        if (index > -1 && index > this.index) {
            throw new IndexOutOfBoundsException();
        }
        final T res = (T) objects[index];
        System.arraycopy(objects, index + 1, objects, index, objects.length - 1 - index);
        this.objects[--index] = null;
        return res;
    }


    public Iterator <T> iterator() {
        return new Iterator <T>() {
            int ind;
            @Override
            public boolean hasNext() {
                return ind < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) objects[ind++];
            }
        };
    }

}
