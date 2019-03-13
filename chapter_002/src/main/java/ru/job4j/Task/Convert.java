package ru.job4j.Task;
import java.util.*;

public class Convert {
    public Convert(){   // конструктор по умолчанию писать нет смысла

    }

    //Converts array to list
    List<Integer> makeList(int[][] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {    // можно использовать foreach d 2-x циклах, сократить код
            for (int j = 0; j < array[i].length; j++)   //усложненная логика
                list.add(array[i][j]);
        }
        return list;
    }


    //Converts list to array
    public int[][] makeArray(List<Integer> list, int rws) {
        Iterator<Integer> iterator = list.iterator();
        int cls = list.size() / rws + (list.size() % rws == 0 ? 0 : 1); // усложненная логика


        int[][] array = new int[rws][cls];
        for (int i = 0; i < rws; i++) {
            for (int j = 0; j < cls; j++) {
                if (iterator.hasNext())       // усложненная логика
                    array[i][j] = iterator.next();
                else
                    array[i][j] = 0;
            }
        }
        return array;
    }
}
