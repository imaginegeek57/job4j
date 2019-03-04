package ru.job4j.tracker;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Item {
    protected static int length;
    private String id;
    private String name;
    private String description;
    private long create;
    private String delete;
    private String[] comments;
    public Item() {
    }
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
    public long getCreate() {
        return this.create;
    }
    public String[] getComments() {
        return this.comments;
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDelete() {
        return this.delete;
    }
}
