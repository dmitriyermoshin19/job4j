package ru.job4j.oop.tracker;

public class CreateAction extends BaseAction {

    public CreateAction(String name) {
        super(name);
    }
    @Override
    public String name() {
        return super.name();
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.print("Item created");
        return true;
    }
}
