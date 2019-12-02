package ru.job4j.oop.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.length);
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Input validate = new ValidateInput(new ConsoleInput());
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction("=== Create a new Item ===="),
                new FindAllAction("All items:"),
                new ReplaceAction("=== Edit item ==="),
                new DeleteAction("=== Delete item ==="),
                new FindByIdAction("=== Find item by Id ==="),
                new FindItemsByNameAction("=== Find items by name ==="),
                new ExitProgramAction("=== Exit Program ==="),
        };
        new StartUI().init(validate, tracker, actions);
    }
}
