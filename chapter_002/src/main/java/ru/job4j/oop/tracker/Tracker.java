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

    public boolean replace(String id, Item item) {
        boolean rst = false;
        for (int i = 0; i < position && items[i] != null; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = item;
                item.setId(id);
                rst = true;
                break;
            }
        }
        return rst;
    }

    public Item[] findByName(String name) {
        int caunt = 0;
        Item[] rst = new Item[position];
        for (int i = 0; i < position && items[i] != null; i++) {
            if (items[i].getName().equals(name)) {
                rst[caunt++] = this.items[i];
            }
        }
        return Arrays.copyOf(rst, caunt);
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }
    public boolean delete(String id) {
        boolean rst = false;
        for (int i = 0; i < position && items[i] != null; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = null;
                System.arraycopy(items, i + 1, items, i, position - i);
                position--;
                rst = true;
                break;
            }
        }
        return rst;
    }
}
