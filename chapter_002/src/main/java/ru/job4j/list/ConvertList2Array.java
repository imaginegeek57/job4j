package ru.job4j.list;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.List;
public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = 0;
        for (Integer List: list) {
            if(List % 2 != 0) {
                cells = cells + 1;
        }
            }
        int[][] array = new int[rows][cells];
        return array;
    }
}

