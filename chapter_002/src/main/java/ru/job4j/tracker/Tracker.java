package ru.job4j.tracker;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */

import java.util.*;
import java.util.List;
import java.util.ArrayList;

public class Tracker implements ITracker {
    /**
     * Массив для хранение заявок.
     */
    private final List<Item> items = new ArrayList<>(100);
    private static final Random RN = new Random();
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }
    // Метод добавляет заявку по id
    public boolean findById(Integer id) {
        for (Item it : this.items) {
            if (it.getName().equals(id)) {
                items.add(it);
            }
        }
        return true;
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private Integer generateId() {
        return RN.nextInt(100);
    }

    // Метод должен заменить ячейку в массиве this.items
    public void replace(Integer id, Item item) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                items.set(i, item);
                item.setId(id);
                break;
            }
        }
    }


    @Override
    public boolean delete(Integer key) {
        for (Item it : this.items) {
            if (it.getId().equals(key)) {
                items.remove(it);
                return true;
            }
        }
        return false;
    }

    public boolean findByName(String key) {
        for (Item it : this.items) {
            if (it.getName().equals(key)) {
                items.add(it);
            }
        }
        return true;
    }

    public List <Item> findAll() {
        List<Item> items = new ArrayList<>();
        for (Item it : this.items) {
            items.add(it);
        }
            return items;
    }
}

