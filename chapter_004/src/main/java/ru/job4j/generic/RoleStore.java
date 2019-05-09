package ru.job4j.generic;

public class RoleStore<T> implements Store<User> {

    private SimpleArray[] arrays;

    private int index = 0;

    public RoleStore(int size) {
        this.arrays = new SimpleArray[size];
    }

    @Override
    public void add(User model) {
        this.arrays = new SimpleArray[model];
    }

    @Override
    public boolean replace(String id, User model) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public User findById(String id) {
        return null;
    }
}
