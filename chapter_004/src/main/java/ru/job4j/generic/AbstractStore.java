package ru.job4j.generic;

public abstract class AbstractStore<T extends Base> implements Store<T> {

    private SimpleArray<T> arrays;
    private int index = 0;

    public void add(T model) {
        this.arrays.add(model);
    }
    @Override
    public boolean replace(String id, T model) {
        boolean res = false;
        for (int i = 0; i < this.arrays.size(); i++) {
            T item = this.arrays.get(i);
            if (item.getId().equals(id)) {
                this.arrays.set(i, model);
                res = true;
                break;
            }
        }
        return res;
    }

    @Override
    public boolean delete(String id) {
        boolean res = false;
        for (int i = 0; i < this.arrays.size(); i++) {
            T item = this.arrays.get(i);
            if (item.getId().equals(id)) {
                arrays.remove(i);
                res = true;
                break;
            }
        }
        return res;
    }

    @Override
    public T findById(String id) {
        T res = null;
        for (int i = 0; i < this.arrays.size(); i++) {
            T item = this.arrays.get(i);
            if (item.getId().equals(id)) {
                res = this.arrays.get(i);
            }
        }
        return res;
    }
}
