package ru.job4j.collection;
import java.util.Iterator;
public class IteratorExample implements Iterator {
   int[][] value = {
            {1, 2},
            {3, 4}
    };
    private int i,j;
    IteratorExample(int[][] value) {
        this.value = value;
    }

    public boolean hasNext() {
        return value.length > value[i][j];
    }

    public Object next() {
        int gh = value[i][j];
        while (i < value.length && j >= value[i].length) {
            i++;
        }
        return gh;
    }
}
