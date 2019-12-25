package ru.job4j.collection.collection;
import java.util.Comparator;

public class UserIncByPriority implements Comparator<SortUser> {
    @Override
    public int compare(SortUser o1, SortUser o2) {
        return Integer.compare(o1.getPriority(), o2.getPriority());
    }
}
