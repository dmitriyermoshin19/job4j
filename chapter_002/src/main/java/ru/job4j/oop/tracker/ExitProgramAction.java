package ru.job4j.oop.tracker;

public class ExitProgramAction extends BaseAction {

    public ExitProgramAction(String name) {
        super(name);
    }
    @Override
    public String name() {
        return super.name();
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
