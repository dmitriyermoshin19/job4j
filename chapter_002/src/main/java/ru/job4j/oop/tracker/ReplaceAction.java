package ru.job4j.oop.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.print("Enter id: ");
        String id = input.askStr("");
        System.out.print("Edit name: ");
        String name = input.askStr("");
        Item item = new Item(name);
        tracker.replace(id, item);
        return true;
    }
}
