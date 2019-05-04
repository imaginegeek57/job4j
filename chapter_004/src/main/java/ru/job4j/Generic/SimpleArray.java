package ru.job4j.Generic;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterator<T> {

    Object[] objects;

    int index = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T model) {
        this.objects[index++] = model;
    }
    public T set(int index, T model) {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return (T) (this.objects[index] = model);
    }

    public T get(int position) {
        return (T) this.objects[position];
    }
    @Override
    public boolean hasNext() {
        if (objects == null || index < 0 || index >= objects.length ) {
        }
        return index < this.objects.length;
    }
    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return (T) this.objects[index++];
    }
    public T remove(int index) {
        if (objects == null || index < 0 || index >= objects.length ) {
        }
        Objects[]result = new Objects[objects.length - 1];
        System.arraycopy(objects, 0 ,result, 0, index);
        if (objects.length != index) {
            System.arraycopy(objects, index + 1, result, index, objects.length - index - 1);
        }
        return (T)result;
    }
}
