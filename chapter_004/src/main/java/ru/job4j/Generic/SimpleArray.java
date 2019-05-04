package ru.job4j.Generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterator<T> {

    Object[] objects;

    int index = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T model) {
        this.objects[index++] = model;

    }
//    public T set(int index, T model) {
//        return (T) this.objects[index] = model;
//    }

    public T get(int position) {
        return (T) this.objects[position];
    }
    @Override
    public boolean hasNext() {
        return index < this.objects.length;
    }
    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return (T) this.objects[index++];
    }
    @Override
    public void remove() {

    }
}
