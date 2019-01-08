package ru.job4j.tracker;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.*;

public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List <UserAction> actions = new ArrayList <>();
    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }
    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem(0,"Add program"));
        this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new UpdateItem(2, "Edit item"));
        this.actions.add(new DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemsByName(5, "Find items by name"));
        this.actions.add(new ExitProgram(6, "Exit Program"));
    }
    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }
    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
    private class AddItem implements UserAction {
        private int key;
        private String name;
        public AddItem(int key, String name) {
            this.key = key;
            this.name = name;
        }
        public int key() {
            return 0;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Adding new item --------------");
            String name = input.ask("Please, provide item name:");
            String desc = input.ask("Please, provide item description:");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ New Item with Id : " + item.getId());
            System.out.println("------------ New Item with Name : " + item.getName());
            System.out.println("------------ New Item with Description : " + item.getDescription());
        }
        @Override
        public String info() {
            return "Add new Item.";
        }
    }
    private class UpdateItem implements UserAction {
        private int key;
        private String name;

        public UpdateItem(int key, String name) {
            this.key = key;
            this.name = name;
        }
        @Override
        public int key() {
            return 2;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки");
            String id = input.ask("Введите id заявки :");
            String desc = input.ask("Введите описание заявки");
            Item item = new Item(id, name, desc);
            tracker.replace(id, item);
        }
        @Override
        public String info() {
            return "Update Item.";
        }
    }
    private class ShowItems implements UserAction {
        private int key;
        public ShowItems(int key) {
            this.key = key;
        }
        @Override
        public int key() {
            return 1;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                    System.out.println();
            }
        }
        @Override
        public String info() {
            return "Show all Items.";
        }
    }
    private class DeleteItem implements UserAction {
        private int key;
        private String id;
        public DeleteItem(int key, String id) {
            this.key = key;
            this.id = id;
        }
        @Override
        public int key() {
            return 3;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("--------Удаление заявки--------");
            String id = input.ask("Введите id заявки :");
            tracker.delete(id);
        }
        @Override
        public String info() {
            return "Delete Item.";
        }
    }
    private class FindItemById implements UserAction {
        private int key;
        private String id;
        public FindItemById(int key, String id) {
            this.key = key;
            this.id = id;
        }
        @Override
        public int key() {
            return 4;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки :");
            Item byId = tracker.findById(id);
            if (byId != null) {
                System.out.println(byId);
            } else {
                System.out.println("Item not found");
            }
        }
        @Override
        public String info() {
            return "Find Items.";
        }
    }
    private class FindItemsByName implements UserAction {
        private int key;
        private String name;
        public FindItemsByName(int key, String name) {
            this.key = key;
            this.name = name;
        }
        @Override
        public int key() {
            return 5;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки");
            Item[] byName = tracker.findByName(name);
            if (byName.length != 0) {
                for (Item item : byName) {
                    System.out.println(item);
                }
            } else {
                System.out.println("Заявок с данным именем не найдено");
            }
        }
        @Override
        public String info() {
            return "Find items by name.";
        }
    }
    private class ExitProgram implements UserAction {
        private int key;
        public ExitProgram(int key) {
            this.key = key;
        }
        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {

            //.....
            //.....?
        }
            @Override
            public String info () {
                return "Exit Program.";
            }

    }
}


