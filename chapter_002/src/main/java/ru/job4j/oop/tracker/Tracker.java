package ru.job4j.oop.tracker;
import java.util.*;

public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private Item[] items = new Item[100];

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

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }
    public Item findById(String id) {
        Item rst = null;
        for (int i = 0; i < position && items[i] != null; i++) {
            if (items[i].getId().equals(id)) {
                rst = items[i];
                break;
            }
        }
        return rst;
    }
    public Item findByName(String name) {
        Item rst = null;
        for (int i = 0; i < position && items[i] != null; i++) {
            if (items[i].getName().equals(name)) {
                rst = items[i];
                break;
            }
        }
        return rst;
    }
    public Item replace(String id, Item item) {
        Item rst = null;
        for (int i = 0; i < position && items[i] != null; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = item;
                rst = items[i];
                break;
            }
        }
        return rst;
    }
    public Item delete(String id) {
        Item rst = null;
        for (int i = 0; i < position && items[i] != null; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = null;
                System.arraycopy(items, i, items, i + 1, position -i);
                position--;
                rst = items[i];
               // System.out.println(items[i+2].getName());
                break;
            }
        }
        return rst;
    }
    public Item[] findAll() {
        Item[] result = new Item[position];
        for (int i = 0; i != position; i++) {
            result[i] = this.items[i];
        }
        return result;
    }
}
