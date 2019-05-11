package ru.job4j.generic;


import java.util.Objects;

public abstract class Base {

    private final String id;

    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("is ").append("\"").append(id).append("\"");
        return res.toString();
    }
}
