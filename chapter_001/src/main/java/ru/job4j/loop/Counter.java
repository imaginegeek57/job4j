package ru.job4j.loop;
/**
 * @author Vlad Mon
 * @version $Id$
 * @since 0.1
 */

public class Counter {

    public int count(int start, int finish) {
        int result = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 != 0) {
           continue;
            }
        }
        return result;

    }

}