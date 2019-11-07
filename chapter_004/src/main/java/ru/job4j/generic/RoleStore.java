package ru.job4j.generic;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */

import java.util.*;
import java.util.List;
import java.util.ArrayList;
public class RoleStore extends AbstractStore<Role> {

    public RoleStore(SimpleArray <Role> arrays) {
        super(arrays);
    }

    @Override
    public void add(Role model) {
        super.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        return super.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return super.delete(id);
    }

    @Override
    public Role findById(String id) {
        return super.findById(id);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
