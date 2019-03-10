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
        int min = l.length - r.length;
            for (int i : min) {
                if(l[i] != r[i]) {
                }
        }
        return min;
    }
}