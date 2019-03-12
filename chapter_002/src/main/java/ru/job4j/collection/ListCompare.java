package ru.job4j.collection;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */

import java.util.*;
import java.util.Comparator;
public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char[] l = left.toCharArray();
        char[] r = right.toCharArray();
        final int min = Math.min(l.length, r.length);
            for (int i = 0; i < min; i++) {
                if(l[i] != r[i]) {
                    return Character.compare(l[i], r[i]);
                }
        }
        return Integer.compare(left.length(), right.length());
    }
}