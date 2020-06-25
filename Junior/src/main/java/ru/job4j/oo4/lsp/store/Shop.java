package ru.job4j.oo4.lsp.store;

import ru.job4j.oo4.lsp.Food;

import java.util.LinkedList;
import java.util.List;

public class Shop extends Store {
    List<Food> shopList = new LinkedList<>();

    @Override
    public void addToStore(Food food) {
        shopList.add(food);
    }

    @Override
    public List<Food> getListStore() {
        return shopList;
    }
}
