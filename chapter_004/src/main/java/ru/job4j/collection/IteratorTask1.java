package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorTask1 implements Iterator {

    private  final int[] numbers;
    private int index = 0;
    public IteratorTask1(int[] numbers) {
        this.numbers = numbers;

    }

    @Override
    public boolean hasNext() {

        return index % 2 + 1 < numbers.length;
    }

    @Override
    public Object next() {
       if (!hasNext()) {
           throw new NoSuchElementException();
       }
       int result = numbers[index++];
       if (result % 2 == 0) {
       }
        return result;
    }
}
