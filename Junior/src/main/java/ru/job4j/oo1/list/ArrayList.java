package ru.job4j.oo1.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements Iterable<E> {
    private Object[] container;
    private int index = 0;
    private int modCount = 0;

    public ArrayList() {
        this.container = new Object[10];
    }

    public Object[] getContainer() {
        if (this.index == this.container.length) {
            Object[] newContainer = new Object[this.index * 2];
            System.arraycopy(this.container, 0, newContainer, 0, this.index);
            this.container = newContainer;
            this.modCount++;
        }
        return this.container;
    }

    public void add(E value) {
        this.container = this.getContainer();
        this.container[index++] = value;
    }

    public E get(int position) {
        E result = null;
        if (container[position] != null) {
            result = (E) this.container[position];
        }
        return result;
    }

    public int size() {
        return this.container.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int itIndex = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (this.expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return itIndex < index;
            }

            @Override
            public E next() {
                if (this.expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[itIndex++];
            }
        };
    }
}
