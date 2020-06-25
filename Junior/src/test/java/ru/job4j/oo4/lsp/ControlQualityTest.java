package ru.job4j.oo4.lsp;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.oo4.lsp.store.*;
import java.time.LocalDate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ControlQualityTest {
    private ControlQuality cq;
    private Shop shop;
    private WareHouse wareHouse;
    private Trash trash;
    LocalDate now;

    @Before
    public void init() {
        shop = new Shop();
        wareHouse = new WareHouse();
        trash = new Trash();
        now = LocalDate.of(2020, 1, 1);
        cq = new ControlQuality(shop, wareHouse, trash, now);
    }

    @Test
    public void whenRelocateTheFood() {
        Food milk = new Food("Milk",
                LocalDate.of(2020, 5, 11),
                LocalDate.of(2019, 1, 12),
                50);
        Food milkFromFuture = new Food("Milk From The Future",
                LocalDate.of(2020, 12, 31),
                LocalDate.of(2020, 1, 10),
                50);
        Food whiteBread = new Food("White Bread",
                LocalDate.of(2020, 1, 3),
                LocalDate.of(2020, 1, 1),
                50);
        Food wheatFlour = new Food("Wheat Flour",
                LocalDate.of(2020, 1, 5),
                LocalDate.of(2019, 11, 10),
                50);
        cq.relocateTheFood(milk);
        cq.relocateTheFood(milkFromFuture);
        cq.relocateTheFood(whiteBread);
        cq.relocateTheFood(wheatFlour);

        assertTrue(shop.getListStore().contains(milk));
        assertTrue(trash.getListStore().contains(milkFromFuture)); //product with illegal production date
        assertTrue(wareHouse.getListStore().contains(whiteBread));
        assertTrue(shop.getListStore().contains(wheatFlour));

        int index = shop.getListStore().indexOf(wheatFlour);
        assertThat(shop.getListStore().get(index).getDiscount(), is(50));
    }
}
