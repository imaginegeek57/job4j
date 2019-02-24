package ru.job4j.list;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.ArrayList;
import java.util.List;
public class ConvertMatrix2List {
    public List<Integer> toList (int[][] array) {
        List<Integer> list = new ArrayList <>();
        for(int[] i : array) {
            for (int j : i) {
                list.add(j);
            }
        }
        return list;
    }
}
