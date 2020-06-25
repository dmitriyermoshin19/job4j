package ru.job4j.oo4.lsp;

import ru.job4j.oo4.lsp.store.Store;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Class that controls the placement of products in different stores,
 */
public class ControlQuality {
    private FoodRelocateStrategy relocateFood;
    private final Store shop;
    private final Store wareHouse;
    private final Store trash;
    LocalDate now;

    public ControlQuality(Store shop, Store wareHouse, Store trash, LocalDate now) {
        this.shop = shop;
        this.wareHouse = wareHouse;
        this.trash = trash;
        this.now = now;
    }

    /**
     * Shelf life  in %.
     */
    long getExpiredRatio(Food food) {
        LocalDate createDate = food.getCreateDate();
        LocalDate expiredDate = food.getExpiredDate();
        long fresh = ChronoUnit.DAYS.between(createDate, expiredDate);
        long increase = ChronoUnit.DAYS.between(createDate, now);
        return increase * 100 / fresh;
    }

    /**
     * The choice of the Store depending on the expired ratio
     */
    private void chooseRelocateStrategy(long expiredRatio) {
        if (expiredRatio >= 0 && expiredRatio <= 25) {
            relocateFood = wareHouse::addToStore;
        }
        if (expiredRatio > 25 && expiredRatio <= 75) {
            relocateFood = shop::addToStore;
        }
        if (expiredRatio > 75 && expiredRatio < 100) {
            relocateFood = food -> {
                food.setDiscount(50);
                shop.addToStore(food);
            };
        }
        if (expiredRatio >= 100 || expiredRatio < 0) {
            relocateFood = trash::addToStore;
        }
    }

    /**
     * Relocate of the product in the store
     */
    protected void relocateTheFood(Food food) {
        chooseRelocateStrategy(getExpiredRatio(food));
        relocateFood.relocate(food);
    }
}
