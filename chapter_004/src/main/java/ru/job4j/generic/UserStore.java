package ru.job4j.generic;


public class UserStore<T> implements Store<User> {

   private SimpleArray<User> array;
   private int index = 0;

    public UserStore(int size) {
        this.array = new SimpleArray(size);
    }
    @Override
    public void add(User model) {
        this.array.add(model);

    }
    @Override
    public boolean replace(String id, User model) {
        for (User i : this.array) {
            if (i.getId().equals(id)) {
                this.array.set(index, model);
                break;
            }
        }
        return false;
    }
    @Override
    public boolean delete(String id) {
        boolean res = false;
        for (User  i: this.array) {
            if (i.getId().equals(id)) {
                array.remove(index);
                res = true;
                break;
            }
        }
        return res;
    }

    @Override
    public User findById(String id) {
        User res = null;
        for (User i : this.array) {
            if (i.getId().equals(id)) {
                res = this.array.get(index);
            }
        }
        return res;
    }
}
