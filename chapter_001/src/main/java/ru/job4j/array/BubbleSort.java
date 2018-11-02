package ru.job4j.array;

/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class BubbleSort {
    public int[] sort(int[] array) {
        int tmp;
        for(int i = 0; i < array.length; i++) {
           for(int j = 0; j < array.length; j++)
            if(array[i] > array[j +1]) {
                tmp = array[j + 1];
                array[i] = tmp;

            }
        }
        return tmp;
    }
}
