package ru.job4j.generic;

public class RoleStore<T> implements Store<Role> {

    private SimpleArray<Role> arrays;

    private int index = 0;

    public RoleStore(int size) {
        this.arrays = new SimpleArray(size);
    }

    @Override
    public void add(Role model) {
        this.arrays.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        for (Role i : this.arrays) {
            if (i.getId().equals(id)) {
                this.arrays.set(index, model);
                break;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        boolean res = false;
        for (Role  i: this.arrays) {
            if (i.getId().equals(id)) {
                arrays.remove(index);
                res = true;
                break;
            }
        }
        return res;
    }

    @Override
    public Role findById(String id) {
        Role res = null;
        for (Role i : this.arrays) {
            if (i.getId().equals(id)) {
                res = this.arrays.get(index);
            }
        }
        return res;
    }
}
