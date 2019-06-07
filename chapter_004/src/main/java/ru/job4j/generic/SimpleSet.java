package ru.job4j.generic;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {

    private int index;
    private SimpleArray<T> array;

    public SimpleSet(int index) {
        this.array = new SimpleArray(index);
    }

    public boolean add(T data) {
        for (T i : this.array) {
            if (i.equals(data)) {
                return false;
            }
        }
        this.array.add(data);
        return true;
    }
    public int size() {
        return array.size();
    }
    public T get(int position) {
        return (T) array.get(position);
    }
    public T remove(int index) {
        return (T) array.remove(index);
    }
    @Override
    public Iterator <T> iterator() {
        return array.iterator();
    }
}
