package ru.job4j.oop.tracker;

public class FindItemsByNameAction extends BaseAction {

    public FindItemsByNameAction(String name) {
        super(name);
    }

    @Override
    public String name() {
        return super.name();
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i].getId() + " " + items[i].getName());
        }
        return true;
    }
}
