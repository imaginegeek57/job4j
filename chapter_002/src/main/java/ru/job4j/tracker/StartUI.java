package ru.job4j.tracker;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */

import java.util.*;

    public class StartUI {
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
            MenuTracker menu = new MenuTracker(this.input, this.tracker);
            List<Integer> range = new ArrayList<>();
            menu.fillActions();
            for (int i = 0; i < menu.getActionsLentgh(); i++) {
                range.add(i);
            }
            do {
                menu.show();
                menu.select(input.ask("select:", range));
            } while (!"y".equals(this.input.ask("Exit?(y): ")));
        }
        /**
         * Запускт программы.
         *
         * @param args
         */
        public static void main(String[] args) {
            new StartUI(new ConsoleInput(), new Tracker()).init();
        }

    }