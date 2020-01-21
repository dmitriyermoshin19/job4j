package ru.job4j.oo1.iterator;

import java.util.Iterator;

public class JaggedArrayIterator implements Iterator {
    private final int[][] values;
    private int row = 0;
    private int cell = 0;

    public JaggedArrayIterator(final int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return (row < values.length - 1)
                || (row == values.length - 1 && cell < values[row].length);
    }

    @Override
    public Object next() {
        int result = values[row][cell];
        if (cell == values[row].length - 1) {
            row++;
            cell = 0;
        } else {
            cell++;
        }
        return result;
    }
}
