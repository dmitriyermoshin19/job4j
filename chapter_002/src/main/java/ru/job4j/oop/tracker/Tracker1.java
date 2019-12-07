package ru.job4j.oop.tracker;

import java.util.Arrays;

public enum Tracker1 {
    ITEM;
    private final Tracker tracker = new Tracker();

    public static Tracker1 getItem() {
        return ITEM;
    }
    // композиция методы оригинала Tracker
    public Item add(Item item) {
        return tracker.add(item);
    }
    public Item findById(String id) {
        return tracker.findById(id);
    }
    public boolean replace(String id, Item item) {
        return tracker.replace(id, item);
    }
    public Item[] findByName(String name) {
        return tracker.findByName(name);
    }
    public Item[] findAll() {
        return tracker.findAll();
    }
    public boolean delete(String id) {
        return tracker.delete(id);
    }

    public static void main(String[] args) {
        Tracker1 tracker1 = Tracker1.ITEM;
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        System.out.println(tracker1 + "   " + result);
    }
}
