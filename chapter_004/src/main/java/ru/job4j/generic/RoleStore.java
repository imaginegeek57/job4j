package ru.job4j.generic;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */

import java.util.*;
import java.util.List;
import java.util.ArrayList;
public class RoleStore implements Store<Role> {

    private SimpleArray<Role> arrays;

    public RoleStore(int size) {
        this.arrays = new SimpleArray (size);
    }

    @Override
    public void add(Role model) {
        this.arrays.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        boolean res = false;
        for (int i = 0; i < this.arrays.size(); i++) {
            Role item = this.arrays.get(i);
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
            Role item = this.arrays.get(i);
            if (item.getId().equals(id)) {
                arrays.remove(i);
                res = true;
                break;
            }
        }
        return res;
    }

    @Override
    public Role findById(String id) {
        Role res = null;
        for (int i = 0; i < this.arrays.size(); i++) {
            Role item = this.arrays.get(i);
            if (item.getId().equals(id)) {
                res = this.arrays.get(i);
            }
        }
        return res;
    }
}
