package ru.job4j.lambda;

import java.util.Comparator;

public class SortByCityAsc implements Comparator<Address> {
    @Override
    public int compare(Address o1, Address o2) {
        return o1.getCity().compareTo(o2.getCity());
    }
}
