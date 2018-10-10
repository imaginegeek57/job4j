package ru.job4j.max;
/**
 * @author Vlad Mon
 * @version $Id$
 * @since 0.1
 */

public class Max {

    public int max(int first, int second){
       boolean Maxim = first < second;
       return Maxim ? first : second;
    }
}