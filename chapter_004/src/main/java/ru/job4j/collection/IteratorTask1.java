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
        for (int i = index; i < numbers.length; i++){
            if (numbers[i] % 2 == 0) {
                index = i;
                return true;
            }
        }
        return false;
    }

    @Override
    public Object next() {
       if (!hasNext()) {
           throw new NoSuchElementException();
       }
        return numbers[index++];
    }
}
