package ru.job4j.oo1.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator {
    final int[] numbers;
    private int index = 0;

    public EvenIterator(final int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        while (index < numbers.length) {
            if (numbers[index] % 2 == 0) {
                result = true;
                break;
            } else {
                index++;
            }
        }
        return result;
    }

    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return numbers[index++];
    }
}
