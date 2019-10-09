package ru.job4j.condition;

public class Max {
    public static int max1(int left, int right) {
        int result = left>right? left : right;
        return result;
    }
    public static int max2(int left, int right) {
        int result = left<right? right : left ;
        return result;
    }
    public static int max3(int left, int right) {
        int result = left==right? left : right;
        return result;
    }

}
