package ru.job4j.collection.collection;

import java.util.Comparator;

public class UserDescByPriority implements Comparator<SortUser> {
    @Override
    public int compare(SortUser o1, SortUser o2) {
        return Integer.compare(o2.getPriority(), o1.getPriority());
    }
}
