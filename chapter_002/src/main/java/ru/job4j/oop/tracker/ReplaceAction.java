package ru.job4j.oop.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        String name = input.askStr("Edit name: ");
        Item item = new Item(name);
        tracker.replace(id, item);
        System.out.print("Item edited");
        return true;
    }
}
