package ru.job4j.oop.tracker;

public abstract class BaseAction implements UserAction {

    private final String name;

    protected BaseAction(final String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return this.name;
    }
}
