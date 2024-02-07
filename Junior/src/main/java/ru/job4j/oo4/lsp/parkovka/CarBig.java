package ru.job4j.oo4.lsp.parkovka;

import java.util.Objects;

/**
 * Data model for big cars
 */
public class CarBig implements Car {
    int size;
    int number;

    public CarBig(int size, int number) {
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
        if (!(o instanceof CarBig)) {
            return false;
        }
        CarBig car = (CarBig) o;
        return size == car.size
                && number == car.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, number);
    }

}
