package ru.job4j.oop.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.print("Enter id: ");
        String id = input.askStr("");
        tracker.delete(id);
        return true;
    }
}
