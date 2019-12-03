package ru.job4j.oop.tracker;

public class Tracker4 {
    private final Tracker tracker = new Tracker();
    private Tracker4() {}

    public static Item getItem() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final Item INSTANCE = new Item("Single");
    }
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

}
