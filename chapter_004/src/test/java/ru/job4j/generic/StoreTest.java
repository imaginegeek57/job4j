package ru.job4j.generic;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StoreTest {

    @Test
    public void whenWeUseRoleStore() {
        RoleStore role = new RoleStore(new SimpleArray<Role>(10));
        role.add(new Role("123"));
        role.add(new Role("147"));
        role.add(new Role("Hi"));
        role.replace("147", new Role("ss1"));
        Role result = role.findById("ss1");
        assertThat(result, is("ss1"));
    }
    @Test
    public void whenWeUseUserStore() {
        UserStore user = new UserStore(new SimpleArray<User>(10));
        user.add(new User("123"));
        user.add(new User("753"));
        user.add(new User("1423"));
        user.add(new User("Hi"));
        user.replace("1423", new User("success"));
        User result = user.findById("success");
        assertThat(result, is("success"));
    }
}