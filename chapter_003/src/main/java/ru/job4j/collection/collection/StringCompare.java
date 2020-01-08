package ru.job4j.collection.collection;
import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rst = left.length() - right.length();
        int min = Math.min(left.length(), right.length());
        int index = 0;
        while (index < min) {
            int rst1 = Character.compare(left.charAt(index), right.charAt(index));
            if (rst1 != 0) {
                rst = rst1;
                break;
            }
            index++;
        }
        return rst;
    }
}
