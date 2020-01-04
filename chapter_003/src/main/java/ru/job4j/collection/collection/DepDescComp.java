package ru.job4j.collection.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int result = o1.length() - o2.length();
        int min = Math.min(o1.length(), o2.length());
        for (int i = 0; i < min; i++) {
            int result1 = Character.compare(o2.charAt(i), o1.charAt(i));
            if (result1 != 0) {
                result = result1;
                break;
            }
        }
            return result;
    }
}
