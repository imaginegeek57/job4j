package ru.job4j.generic;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {

    private Object[] objects;
    private int index;
    SimpleArray array = new SimpleArray(index);

    public boolean add(T data) {
        if(data.equals(objects)) {
            return false;
        }
        array.add(data);
        return true;
    }
    public SimpleSet(int size) {
        this.objects = new Object[size];
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
