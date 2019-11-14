package ru.job4j.oop.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(input.askStr(""));
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.replaceItem(tracker);
            } else if (select == 2) {
            StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemById(input, tracker);
            } else if (select == 5) {
                StartUI.findItemsByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        System.out.print("Enter name: ");
        String name = input.askStr("");
        Item item = new Item(name);
        tracker.add(item);
    }
    public static void replaceItem(Tracker tracker) {
        System.out.println("All items:");
        Item[] items = tracker.findAll();
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
    }
    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ===");
        System.out.print("Enter id: ");
        String id = input.askStr("");
        System.out.print("Edit name: ");
        String name = input.askStr("");
        Item item = new Item(name);
        tracker.replace(id, item);
    }
    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        System.out.print("Enter id: ");
        String id = input.askStr("");
        tracker.delete(id);
    }
    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ===");
        System.out.print("Enter id: ");
        String id = input.askStr("");
        System.out.print(tracker.findById(id));
    }
    public static void findItemsByName(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ===");
        System.out.print("Enter name: ");
        String name = input.askStr("");
        Item[] items = tracker.findByName(name);
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
    }
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
