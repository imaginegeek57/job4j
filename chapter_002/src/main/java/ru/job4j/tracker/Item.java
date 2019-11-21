package ru.job4j.tracker;

import java.util.Arrays;
import java.util.List;

/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Item {
    private Integer id;
    private String name;
    private String description;

    public Item() {
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Item(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public String setName(String name) {
        return this.name = name;
    }
    public String getDescription() {
        return this.description;
    }

    public String setDescription(String description) {
        return this.description = description;
    }

    @Override
    public String toString() {
        return "Item{"
                +
                "id='"
                + id
                + '\''
                +
                ", name='"
                + name
                + '\''
                +
                ", description='"
                + description
                + '\''
                +
                '}';
    }
}

