package ru.job4j.condition;

public class SqMax {
    public static int max(int first, int second, int third, int forth) {
        int result = forth;
        if (first > second) {
            if (first > third) {
                if (first > forth) {
                    result = first;
                }
            } else if (third > forth) {
                result = third;
            } else {
                result = forth;
            }
        } else if (second > third) {
            if (second > forth) {
                result = first;
            }
        } else if (third > forth) {
            result = third;
        } else {
            result = forth;
        }
        return result;
    }
}
