package ru.job4j.oop.tracker;

public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "All items:";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
        return true;
    }
}
