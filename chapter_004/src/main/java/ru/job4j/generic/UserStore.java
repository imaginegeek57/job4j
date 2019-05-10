package ru.job4j.generic;


public class UserStore implements Store<User> {

   private SimpleArray<User> array;

    public UserStore(int size) {
        this.array = new SimpleArray(size);
    }
    @Override
    public void add(User model) {
        this.array.add(model);
    }
    @Override
    public boolean replace(String id, User model) {
        boolean res = false;
        for (int i = 0; i < this.array.size(); i++) {
            User item = this.array.get(i);
            if (item.getId().equals(id)) {
                this.array.set(i, model);
                res = true;
                break;
            }
        }
        return res;
    }
    @Override
    public boolean delete(String id) {
        boolean res = false;
        for (int i = 0; i < this.array.size(); i++) {
            User item = this.array.get(i);
            if (item.getId().equals(id)) {
                array.remove(i);
                res = true;
                break;
            }
        }
        return res;
    }

    @Override
    public User findById(String id) {
        User res = null;
        for (int i = 0; i < this.array.size(); i++) {
            User item = this.array.get(i);
            if (item.getId().equals(id)) {
                res = this.array.get(i);
            }
        }
        return res;
    }
}
