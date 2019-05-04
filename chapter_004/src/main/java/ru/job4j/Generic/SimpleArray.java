package ru.job4j.Generic;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {

    Object[] objects;

    int index = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T model) {
        this.objects[index++] = model;
    }
    public T set(int index, T model) {
        if (index > -1 && index < this.index) {
            throw new IndexOutOfBoundsException();
        }
        return (T) (this.objects[index] = model);
    }

    public T get(int position) {
        return (T) this.objects[position];
    }
    public boolean hasNext() {
        if (objects == null || index < 0 || index >= objects.length ) {
        }
        return index < this.objects.length;
    }

    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return (T) this.objects[index++];
    }
    public T remove(int index) {
        if (index > -1 && index < this.index) {
            throw new IndexOutOfBoundsException();
        }
        Objects[]result = new Objects[objects.length - 1];
        System.arraycopy(objects, 0 ,result, 0, index);
        if (objects.length != index) {
            System.arraycopy(objects, index + 1, result, index, objects.length - index - 1);
        }
        return (T)result;
    }
    @Override
    public Iterator <T> iterator() {
        return new SimpleArrayIterator();
    }
}
class SimpleArrayIterator implements Iterator {
    private  int start;
    private final int end;

    SimpleArrayIterator(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean hasNext() {
        return this.start < end;
    }
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return start++;
    }
}
