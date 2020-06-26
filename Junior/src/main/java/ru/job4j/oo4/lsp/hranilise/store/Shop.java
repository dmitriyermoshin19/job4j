package ru.job4j.oo4.lsp.hranilise.store;

import ru.job4j.oo4.lsp.hranilise.Food;

import java.util.LinkedList;
import java.util.List;

public class Shop implements  Store {
    List<Food> listFood = new LinkedList<>();

    @Override
    public boolean accept(Food f, Long expiredRatio) {
        if (expiredRatio > 75 && expiredRatio < 100) {
            f.setDiscount(50);
        }
        return  expiredRatio > 25 && expiredRatio < 100;
    }

    @Override
    public void add(Food f) {
        listFood.add(f);

    }

    @Override
    public List<Food> getListFood() {
        return listFood;
    }
}
