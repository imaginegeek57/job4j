package ru.job4j.array;

/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;
       for (int i = 0; i < data.length; i++) {
            if (data[i] != data[0]) {
                break;
            }
       }
       return result;

    }
}
