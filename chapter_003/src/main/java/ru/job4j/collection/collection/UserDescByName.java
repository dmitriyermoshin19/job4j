package ru.job4j.collection.collection;

import java.util.Comparator;

public class UserDescByName implements Comparator<SortUser> {
    @Override
    public int compare(SortUser o1, SortUser o2) {
        return o2.getName().compareTo(o1.getName());
    }
}
