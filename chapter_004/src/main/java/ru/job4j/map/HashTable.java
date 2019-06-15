package ru.job4j.map;

public class HashTable<K, V> {

    //массив для хранения элементов
    private Item[] table;
    //количество элементов в таблице
    private int count;
    //размер таблицы
    private int size;

    public HashTable(int size) {
        this.size = size;
        table = new Item[size];
        count++;
    }
    public int hash(K key) {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int)key;
        return result;
    }

    public void insert(K key, V value) {
        Item item = new Item(key, value);
        int hash = hash(key);
        while(table[hash] != null) {
            hash++;
            hash %= size;
        }
        table[hash] = item;
    }
    public Item find(K key) {
        int hash = hash(key);
        while(table[hash] != null) {
            if(table[hash].getKey().equals(key))
                return table[hash];
            hash++;
            hash = hash % size;
        }
        return null;
    }
}
