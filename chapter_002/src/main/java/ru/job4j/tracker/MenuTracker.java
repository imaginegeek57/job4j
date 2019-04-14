package ru.job4j.tracker;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.*;
import java.util.function.Consumer;

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
    private ArrayList<UserAction> actions = new ArrayList<>();
    private final Consumer<String> output;
    /**
     * Конструктор.
     *1
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     * @param output
     */
    public MenuTracker(Input input, Tracker tracker, Consumer <String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }
    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActions() {
        return this.actions.size();
    }
    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem(0, "Add program"));
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
                output.accept(action.info());
            }
        }
    }
    class AddItem extends BaseAction {
        public AddItem(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Enter name:");
            String desc = input.ask("Enter description:");
            tracker.add(new Item(name, desc));
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
            return key;
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
            return String.format("%d. %s", key, name);
        }
    }
    private class ShowItems implements UserAction {
        private int key;
        private String name;
        public ShowItems(int key, String name) {
            this.key = key;
            this.name = name;
        }
        @Override
        public int key() {
            return key;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                System.out.println(item);
            }
        }
        @Override
        public String info() {
            return String.format("%d. %s", key, name);
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
            return key;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("--------Удаление заявки--------");
            String id = input.ask("Введите id заявки :");
            tracker.delete(id);
        }
        @Override
        public String info() {
            return String.format("%d. %s", key, id);
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
            return key;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки :");
            Item byId = tracker.findById(id);
            if (byId != null) {
                System.out.println(byId);
            } else {
                output.accept("Item not found");
            }
        }
        @Override
        public String info() {
            return String.format("%d. %s", key, id);
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
            return key;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки");
            List<Item> byName = tracker.findByName(name);
            if (byName.size() != 0) {
                for (Item item : byName) {
                    System.out.println(item);
                }
            } else {
                output.accept("Заявок с данным именем не найдено");
            }
        }
        @Override
        public String info() {
            return String.format("%d, %s", key, name);
        }
    }
    private class ExitProgram implements UserAction {
        private int key;
        private String name;
        public ExitProgram(int key, String name) {
            this.key = key;
            this.name = name;
        }
        @Override
        public int key() {
            return key;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("Выбран пункт Exit Program, досвидания!");
            select(key);
        }
        @Override
        public String info() {
            return String.format("%d. %s", key, name);
        }
    }
}

