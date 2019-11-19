package ru.job4j.oop.tracker;

public class FindItemsByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.print("Enter name: ");
        String name = input.askStr("");
        Item[] items = tracker.findByName(name);
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
        return true;
    }
}
