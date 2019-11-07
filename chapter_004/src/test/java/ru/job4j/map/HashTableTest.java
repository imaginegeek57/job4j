package ru.job4j.map;

import org.junit.Test;

import static org.junit.Assert.*;

public class HashTableTest {

    @Test
    public void testMap() {
        HashTable ht = new HashTable(5);
        ht.insert(110, "h5");
        ht.insert(120, "h16");
        ht.insert(103, "ht1");
        System.out.println(ht.get(110));

    }
}