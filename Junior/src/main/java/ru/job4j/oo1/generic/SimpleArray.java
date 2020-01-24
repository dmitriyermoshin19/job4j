package ru.job4j.oo1.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] array;
    private int index = 0;

    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    public void add(T model) {
        this.array[index++] = model;
    }

    public void set(int position, T model) {
            this.array[position] = model;
    }

    public void remove(int position) {
        System.arraycopy(this.array, position + 1,
                this.array, position, index - position - 1);
        index--;
    }

    public T get(int position) {
        return (T) this.array[position];
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {
            private int indexIt = 0;

            @Override
            public boolean hasNext() {
                return this.indexIt < array.length;
            }

            @Override
            public T next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[indexIt++];
            }
        };
        return iterator;
    }
}
