package ru.job4j.generic;


public class UserStore extends AbstractStore<User> {

    public UserStore(SimpleArray<User> arrays) {
        super(arrays);
    }

    @Override
    public void add(User model) {
        super.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        return super.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return super.delete(id);
    }

    @Override
    public User findById(String id) {
        return super.findById(id);
    }
}
