package ru.job4j.tracker;

import java.util.Arrays;
import java.util.List;

/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Item {
    private String id;
    private String name;
    private String description;


    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Item(String name, String description, String id) {
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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

