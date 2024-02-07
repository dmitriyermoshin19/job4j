package ru.job4j.oo4.lsp.parkovka;

import java.util.Objects;

/**
 * Data model for small cars
 */
public class CarSmall implements Car {
    int size;
    int number;

    public CarSmall(int size, int number) {
        this.size = size;
        this.number = number;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CarSmall)) {
            return false;
        }
        CarSmall car = (CarSmall) o;
        return size == car.size
                && number == car.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, number);
    }
}
