package ru.job4j.oop.tracker;

import java.util.List;
import java.util.function.Consumer;

public class StartUI {
    private final Input input;
    private final Tracker tracker;
    private final Consumer<String> output;

    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions, Consumer<String> output) {
        boolean run = true;
        while (run) {
            this.showMenu(actions, output);
            int select = input.askInt("Select: ", actions.size());
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions, Consumer<String> output) {
        output.accept("Menu.");
        int index = 0;
        for (UserAction act : actions) {
            output.accept(index++ + ". " + act.name());
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
        new StartUI(new StubInput(new String[]{"6"}), new Tracker(), System.out::println).init(validate, tracker, actions, System.out::println);
    }
}
