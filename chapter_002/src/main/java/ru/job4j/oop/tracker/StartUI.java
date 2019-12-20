package ru.job4j.oop.tracker;

import java.util.List;

public class StartUI {

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.size());
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        System.out.println("Menu.");
        int index = 0;
        for (UserAction act : actions) {
            System.out.println(index++ + ". " + act.name());
        }
    }

    public static void main(String[] args) {
        Input validate = new ValidateInput(new ConsoleInput());
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(
                new CreateAction("=== Create a new Item ===="),
                new FindAllAction("All items:"),
                new ReplaceAction("=== Edit item ==="),
                new DeleteAction("=== Delete item ==="),
                new FindByIdAction("=== Find item by Id ==="),
                new FindItemsByNameAction("=== Find items by name ==="),
                new ExitProgramAction("=== Exit Program ===")
                );
        new StartUI().init(validate, tracker, actions);
    }
}
