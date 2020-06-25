package ru.job4j.oo4.lsp.store;

import ru.job4j.oo4.lsp.Food;

import java.util.LinkedList;
import java.util.List;

public class WareHouse extends Store {
    List<Food> wareHouseList = new LinkedList<>();

    @Override
    public void addToStore(Food food) {
        wareHouseList.add(food);
    }

    @Override
    public List<Food> getListStore() {
        return wareHouseList;
    }
}
