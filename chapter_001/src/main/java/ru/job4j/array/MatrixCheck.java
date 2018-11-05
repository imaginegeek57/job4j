package ru.job4j.array;

/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class MatrixCheck {
    public boolean mono(boolean[][] data) {

        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                if (data[i] != data[j]) {
                    result = false;
                    break;
                }
            }

        }
        return result;
    }
}
