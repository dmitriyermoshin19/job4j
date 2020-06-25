package ru.job4j.oo4.lsp.store;

import ru.job4j.oo4.lsp.Food;

import java.util.LinkedList;
import java.util.List;

public class Trash extends Store {
    List<Food> trashList = new LinkedList<>();

    @Override
    public void addToStore(Food food) {
        trashList.add(food);
    }

    @Override
    public List<Food> getListStore() {
        return trashList;
    }
}
