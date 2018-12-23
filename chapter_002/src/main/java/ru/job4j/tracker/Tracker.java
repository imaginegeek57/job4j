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
        }
        // Метод добавляет заявку по id
        public Item findById(String id) {
            Item result = null;
            for (int i = 0; i < position; i++) {
                if (items[i].getId().equals(id)) {
                    result = items[i];
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
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
        }
        // Метод должен заменить ячейку в массиве this.items
        public void replace(String id, Item item) {
            for (int i = 0; i < position; i++) {
                if (items[i].getId().equals(id)) {
                    items[i] = item;
                    item.setId(id);
                    break;
                }
            }
        }
            //должен удалить ячейку в массиве this.items
        public void delete(String id) {
            for (int i = 0; i < position; i++) {
                 if (items[i].getId().equals(id)) {
                 System.arraycopy(items, i + 1, items, i, items.length - 1 - i);
                   position--;
                   break;
                 }
            }
        }
        public Item[] findByName(String key) {
            Item[] result = new Item[position];
            int count = 0;
            for (int i = 0; i < position; i++) {
                if (items[i].getName().equals(key)) {
                    result[count] = items[i];
                }
            }
            return Arrays.copyOf(result, count);
        }

        public Item[] findAll() {
            Item[] result = new Item[this.position];
            for (int index = 0; index != this.position; index++) {
                result[index] = this.items[index];
            }
            return result;
        }
}
