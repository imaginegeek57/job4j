package ru.job4j.array;

import java.util.Arrays;

/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int duplicate = array.length;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = array[duplicate - 1];
                    duplicate--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, duplicate);
    }
}
