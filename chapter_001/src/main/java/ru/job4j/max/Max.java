package ru.job4j.max;
/**
 * @author Vlad Mon
 * @version $Id$
 * @since 0.1
 */

public class Max {

    public int max(int first, int second) {
            return first > second ? first : second;
    }

    public int max(int first, int second, int third) {
        int temp = this.max(first, second);
        int max = this.max(first, second, third);
        return max(max(first, second), third);
    }

    }