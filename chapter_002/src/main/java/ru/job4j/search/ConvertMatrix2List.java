package ru.job4j.search;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.ArrayList;
import java.util.List;
public class ConvertMatrix2List {
    public List<Integer> toList (List[][] array) {
        List<Integer> list = new ArrayList <>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j< array.length; j++) {
                array[i][j] = list;
            }
        }
        return list;
    }
}
