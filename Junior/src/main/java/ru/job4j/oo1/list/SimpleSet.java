package ru.job4j.oo1.list;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
    private ArrayList<T> list = new ArrayList<>();

    public boolean add(T value) {
        boolean result = true;
        for (T e : this.list) {
            if (value.equals(e)) {
                result = false;
                break;
            }
        }
        if (result) {
            this.list.add(value);
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
