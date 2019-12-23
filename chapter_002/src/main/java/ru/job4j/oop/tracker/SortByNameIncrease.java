package ru.job4j.oop.tracker;

import java.util.Comparator;

public class SortByNameIncrease implements Comparator<Item> {
    @Override
    public int compare(Item first, Item second) {
        return first.getName().compareTo(second.getName());
    }
}
