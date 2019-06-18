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
    void addEntry(int hash, K key, V value, int index) {
        Item<K, V> e = table[index];
        table[index] = new Item(key, value);
    }
    public void insert(K key, V value) {
        Item item = new Item(key, value);
        int hash = hash(key.hashCode());
        int i = indexFor(hash, table.length);
        for (Item<K, V> e = table[i]; e != null;) {
            count++;
            addEntry(hash, key, value, i);
        }
    }

//    public V get(K key) {
//        V value = null;
//        for (int i = 0; i < table.length; i++) {
//            if (table[i].equals(key.hashCode())) {
//                value = (V) table[i].getValue();
//                break;
//            }
//        }
//        return value;
//    }

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
