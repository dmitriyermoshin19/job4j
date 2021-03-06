package ru.job4j.oo4.lsp.hranilise.store;

import ru.job4j.oo4.lsp.hranilise.Food;

import java.util.LinkedList;
import java.util.List;

public class WareHouse implements Store {
    List<Food> listFood = new LinkedList<>();

    @Override
    public boolean accept(Food f, Long expiredRatio) {
        return expiredRatio >= 0 && expiredRatio <= 25;
    }

    @Override
    public void add(Food f) {
        listFood.add(f);
    }

    @Override
    public List<Food> getListFood() {
        return listFood;
    }

    @Override
    public void setNewListFood() {
        this.listFood = new LinkedList<>();
    }
}
