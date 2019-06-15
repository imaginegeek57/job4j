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
    static int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
    static int indexFor(int h, int length) {
        return h & (length - 1);
    }
    public void insert(K key, V value) {
        Item item = new Item(key, value);
        int hash = hash((Integer) key);
        while(table[hash] != null) {
            hash++;
            hash %= size;
        }
        table[hash] = item;
    }
    public V get(K key) {
        V value = null;
        for (int i = 0; i < size; i++) {

            if (table[i].getKey().equals(key)) {
                value = (V) table[i].getValue();
                break;
            }
        }
        return value;
    }
    public void put(K key, V value) {
        boolean flag = true;
        for (int i = 0; i < size; i++) {
            if (table[i].getKey().equals(key)) {
                table[i].setValue(value);
                flag = false;
                break;
            }
        }
        if (flag) {
            table[size++] = new Item(key, value);
        }
    }

    public boolean delete(K key) {
        boolean flag = false;
        Item<K, V>[] entry = new Item[size];
        int j = 0;
        int total = size;
        for (int i = 0; i < total; i++) {
            if (!table[i].getKey().equals(key)) {
                entry[j++] = table[i];
            } else {
                flag = true;
                size--;
            }
        }
        table = flag ? entry : table;
        return flag;
    }
}
