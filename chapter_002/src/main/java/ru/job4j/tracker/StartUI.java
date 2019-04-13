package ru.job4j.tracker;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.*;
import java.util.function.Consumer;

public class StartUI {
        private int[] ranges = new int[]{1, 2, 3, 4, 5, 6};
        /**
         * Получение данных от пользователя.
         */
        private final Input input;
        /**
         * Хранилище заявок.
         */
        private final Tracker tracker;
        private final Consumer<String>output;

        /**
         * Конструтор инициализирующий поля.
         *  @param input   ввод данных.
         * @param tracker хранилище заявок.
         * @param output
         */
        public StartUI(Input input, Tracker tracker, Consumer <String> output) {
            this.input = input;
            this.tracker = tracker;
            this.output = output;
        }
        /**
         * Основой цикл программы.
         */
        public void init() {
            MenuTracker menu = new MenuTracker(this.input, this.tracker, output);
            List<Integer> range = new ArrayList<>();
            menu.fillActions();
            for (int i = 0; i < menu.getActions(); i++) {
                range.add(i);
            }
            do {
                menu.show();
                menu.select(Integer.valueOf(input.ask("select:", ranges)));
            } while (!"y".equals(this.input.ask("Exit?(y): ")));
        }
        /**
         * Запускт программы.
         *
         * @param args
         */
        public static void main(String[] args) {
            new StartUI(
                    new ValidateInput(
                            new ConsoleInput()
                    ),
                    new Tracker(),
                    output).init();
        }
    }
