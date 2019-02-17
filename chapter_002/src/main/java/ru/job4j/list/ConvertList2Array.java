package ru.job4j.list;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.List;
public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() / rows;
        if (list.size() % rows != 0) {
            cells = cells + 1;
        }
        int[][] array = new int[rows][cells];
        int count = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (count <array.length) {
                        array[i][j] = list.get(count++);
                    }
                }
            }
        return array;
    }
}