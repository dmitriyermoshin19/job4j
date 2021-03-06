package ru.job4j.oo4.lsp.hranilise;

import java.time.LocalDate;

public class Food {
    private String name;
    private final LocalDate expiredDate;
    private final LocalDate createDate;
    private int price;
    private int discount;

    public Food(String name, LocalDate expiredDate, LocalDate createDate, int price) {
        this.name = name;
        this.expiredDate = expiredDate;
        this.createDate = createDate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
    @Override
    public String toString() {
        return "Food{" + "name=" + name + '}';
    }
}
