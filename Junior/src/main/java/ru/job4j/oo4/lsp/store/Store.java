package ru.job4j.oo4.lsp.store;

import ru.job4j.oo4.lsp.Food;

import java.util.List;

public abstract class Store {

    public abstract void addToStore(Food food);

    public abstract List<Food> getListStore();
}
