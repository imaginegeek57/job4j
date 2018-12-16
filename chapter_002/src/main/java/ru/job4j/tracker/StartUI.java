package ru.job4j.tracker;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.*;
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "1";
    // Константа для для поиска по имени
    private static final String FIND_BY_NAME = "2";
    // Константа для для удаления
    private static final String DELETE = "4";
    //Константа показать все
    private static final String FIND_ALL = "5";
    // Константа для для поиска по id
    private static final String FIND_BY_ID = "3";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                //добавление заявки вынесено в отдельный метод.
                this.createItem();
            } else if (FIND_BY_ID.equals(answer)) {
                findById();
            } else if (FIND_BY_NAME.equals(answer)) {
                findByName();
            } else if (DELETE.equals(answer)) {
                delete();
            } else if (FIND_ALL.equals(answer)) {
                findAll();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }
    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки");
        String desc = this.input.ask("Введите описание заявки");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    // метод удаляет заявку
    private void delete() {
        System.out.println("--------Удаление заявки--------");
        String id = this.input.ask("Введите id заявки :");
        this.tracker.delete(id);
    }
    // Обновление заявки
    private void update() {
        String name = this.input.ask("Введите имя заявки");
        String id = this.input.ask("Введите id заявки :");
        String desc = this.input.ask("Введите описание заявки");
        Item item = new Item(id, desc, name);
        // ....?
    }
    // метод ищет заявку по id
    private void findById() {
        String id = this.input.ask("Введите id заявки :");
        Item byId = tracker.findById(id);
        if (byId != null) {
            System.out.println(byId);
        } else {
            System.out.println("Item not found");
        }
    }
    private void findByName() {
        String name = this.input.ask("Введите имя заявки");
        Item[] byName = this.tracker.findByName(name);
        if (byName.length != 0) {
            for (Item item : byName) {
                System.out.println(item);
            }
            } else {
            System.out.println("Заявок с данным именем не найдено");
            }
        }
        private void findAll() {
        Item[] all = this.tracker.findAll();
        if (all.length != 0) {
            for (Item item : all) {
                System.out.println("Трекер пуст заявок нет");
            }
        }
        }
        private void showMenu() {
            System.out.println("Меню.");
            System.out.println("1.Добавление новой заявки");
            System.out.println("2.Поиск заявки по имени");
            System.out.println("3.Поиск заявки по id");
            System.out.println("4.Удаление заявки");
            System.out.println("5.Показать все заявки");
            System.out.println("6.Выход");
        }

        /**
         * Запускт программы.
         * @param args
         */
        public static void main (String[] args) {
            new StartUI(new ConsoleInput(), new Tracker()).init();
        }

}
