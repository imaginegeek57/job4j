package ru.job4j.collection.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorExample implements Iterator {
    int[][] value = {
            {1, 2},
            {3, 4}
    };
    private int i, j;

    public IteratorExample(int[][] value) {
        this.value = value;
        this.i = i;
        this.j = j;

    }

    @Override
    public boolean hasNext() {
        return i < value.length && j < value[i].length;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int res = value[i][j++];
        if (j == value[i].length) {
            j = 0;
            i++;
        }
        return res;
    }
}
