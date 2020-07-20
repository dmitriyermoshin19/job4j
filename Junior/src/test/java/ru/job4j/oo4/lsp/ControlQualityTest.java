package ru.job4j.oo4.lsp;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.oo4.lsp.hranilise.ControlQuality;
import ru.job4j.oo4.lsp.hranilise.Food;
import ru.job4j.oo4.lsp.hranilise.store.*;
import java.time.LocalDate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ControlQualityTest {
    private final Shop shop = new Shop();
    private final WareHouse wareHouse = new WareHouse();
    private final Trash trash = new Trash();
    private final ControlQuality cq = new ControlQuality(shop, wareHouse, trash);
    LocalDate now = LocalDate.of(2020, 1, 1);
    LocalDate now1 = LocalDate.of(2020, 5, 1);
    Food milk = new Food("Milk",
            LocalDate.of(2020, 5, 11),
            LocalDate.of(2019, 1, 12),
            50);
    Food milkBed = new Food("Milk bed",
            LocalDate.of(2019, 12, 31),
            LocalDate.of(2019, 1, 10),
            50);
    Food whiteBread = new Food("White Bread",
            LocalDate.of(2020, 1, 3),
            LocalDate.of(2020, 1, 1),
            50);
    Food wheatFlour = new Food("Wheat Flour",
            LocalDate.of(2020, 1, 5),
            LocalDate.of(2019, 11, 10),
            50);

    @Before
    public void init() {
        cq.allocatesTheFood(milk, cq.getExpiredRatio(milk, now));
        cq.allocatesTheFood(milkBed, cq.getExpiredRatio(milkBed, now));
        cq.allocatesTheFood(whiteBread, cq.getExpiredRatio(whiteBread, now));
        cq.allocatesTheFood(wheatFlour, cq.getExpiredRatio(wheatFlour, now));
    }

    @Test
    public void whenAllocateTheFood() {
        assertTrue(shop.getListFood().contains(milk));
        System.out.println();
        assertTrue(trash.getListFood().contains(milkBed));
        assertTrue(wareHouse.getListFood().contains(whiteBread));
        assertTrue(shop.getListFood().contains(wheatFlour));
        int index = shop.getListFood().indexOf(wheatFlour);
        assertThat(shop.getListFood().get(index).getDiscount(), is(50));
    }

    @Test
    public void whenReallocatesFoods() {
        cq.reallocatesFoods(now1);
        assertTrue(trash.getListFood().contains(wheatFlour));
    }
}
