package ru.job4j.tracker;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.*;

public class Tracker extends Item {
        /**
         * Массив для хранение заявок.
         */
        private final Item[] items = new Item[100];
        private static final Random RN = new Random();
        /**
         * Указатель ячейки для новой заявки.
         */
        private int position = 0;
        /**
         * Метод реализаущий добавление заявки в хранилище
         * @param item новая заявка
         */
        public Item add(Item item) {
            item.setId(this.generateId());
            this.items[this.position++] = item;
            return item;

            /**
             * Метод
              */
        }
        public Item findById(String id) {
            Item result = null;
            for(Item item : items) {
                if(items != null && item.getId().equals(id)) {
                    result =item;
                    break;
                }
            }
            return result;
        }
        /**
         * Метод генерирует уникальный ключ для заявки.
         * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
         * @return Уникальный ключ.
         */
        private String generateId() {
            String.valueOf(System.currentTimeMillis() + RN.nextInt(100));

            return null;
        }

}
