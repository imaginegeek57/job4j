package ru.job4j.loop;
/**
 * @author Vlad Mon
 * @version $Id$
 * @since 0.1
 */

public class Factorial {

    public int calc(int n) {
        int resolt = 1;
        for (int i = 1; i <= n; i++) {
            resolt = resolt * i;
        }
        return resolt;

    }

}