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
            Item a = items[i];
            if (a.getId().equals(id)) {
                rst = a;
                break;
            }
        }
        return rst;
    }
    public boolean replace(String id, Item item) {
        boolean rst = false;
        for (int i = 0; i < position && items[i] != null; i++) {
            Item a = items[i];
            if (a.getId().equals(id)) {
                items[i] = item;
                rst = true;
            }
        }
        return rst;
    }
    public boolean delete(String id) {
        boolean rst = false;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = null;
                System.arraycopy(items, i, items, i + 1, position - i);
                position--;
                rst = true;
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
