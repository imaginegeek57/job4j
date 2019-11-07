package ru.job4j.collection.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    public Iterator <Integer> convert(Iterator <Iterator <Integer>> it) {
        return new Iterator <Integer>() {
            private Iterator <Integer> Iterator = (new ArrayList <Integer>()).iterator();

            @Override
            public boolean hasNext() {
                while (it.hasNext() && !Iterator.hasNext()) {
                    Iterator = it.next();
                }
                return Iterator.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return Iterator.next();
            }
        };
    }
}
