package ru.job4j.oo4.lsp.hranilise.store;

import ru.job4j.oo4.lsp.hranilise.Food;
import java.util.List;

public interface  Store {

    /**
     * The choice of the Store depending on the expired ratio
     */
    boolean accept(Food f, Long expiredRatio);

    void add(Food f);

    List<Food> getListFood();

    void setNewListFood();
}
