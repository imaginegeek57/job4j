package ru.job4j.generic;


public class UserStore extends AbstractStore<User> {

   private SimpleArray<User> arrays;

    public UserStore(SimpleArray <User> arrays) {
        this.arrays = arrays;
    }
}
