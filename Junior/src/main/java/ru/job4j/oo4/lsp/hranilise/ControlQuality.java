package ru.job4j.oo4.lsp.hranilise;

import ru.job4j.oo4.lsp.hranilise.store.Shop;
import ru.job4j.oo4.lsp.hranilise.store.Store;
import ru.job4j.oo4.lsp.hranilise.store.Trash;
import ru.job4j.oo4.lsp.hranilise.store.WareHouse;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;

/**
 * Class that controls the placement of products in different stores,
 */
public class ControlQuality {
    List<Store> listStore = new LinkedList<>();

    public ControlQuality() {

    }

    public ControlQuality(Shop shop, WareHouse wareHouse, Trash trash) {
        this.listStore.add(shop);
        this.listStore.add(wareHouse);
        this.listStore.add(trash);
    }

    /**
     * Shelf life  in %.
     */
    public long getExpiredRatio(Food food, LocalDate now) {
        LocalDate createDate = food.getCreateDate();
        LocalDate expiredDate = food.getExpiredDate();
        long fresh = ChronoUnit.DAYS.between(createDate, expiredDate);
        long increase = ChronoUnit.DAYS.between(createDate, now);
        return increase * 100 / fresh;
    }

    /**
     * Relocate of the product in the store
     */
    public void allocatesTheFood(Food f, Long expiredRatio) {
        for (Store store : this.listStore) {
            if (store.accept(f, expiredRatio)) {
                store.add(f);
                break;
            }
        }
    }

    /**
     * Retrieves all products from all stores.
     */
    private List<Food> getListFoods() {
        List<Food> listFoods = new LinkedList<>();
        for (Store store : this.listStore) {
            listFoods.addAll(store.getListFood());
            store.setNewListFood();
        }
        return listFoods;
    }

    /**
     * Reallocates products across all stores.
     */
    public void reallocatesFoods(LocalDate now) {
        List<Food> listFoods = this.getListFoods();
        for (Food f : listFoods) {
            long expiredRatio = getExpiredRatio(f, now);
            allocatesTheFood(f, expiredRatio);
        }
    }
}
