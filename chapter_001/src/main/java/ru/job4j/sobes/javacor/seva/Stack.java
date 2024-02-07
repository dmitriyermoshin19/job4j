package ru.job4j.sobes.javacor.seva;

import java.util.LinkedList;
import java.util.List;

public class Stack {
    private final List<Integer> list = new LinkedList<>();
    private Integer lastMax;

    public int getSize() {
        return list.size();
    }

    public void push(int value) {
        if (lastMax == null && getSize() == 0) {
            lastMax = value;
        } else if (lastMax != null && lastMax < value) {
            lastMax = value;
        }
        list.add(value);
    }

    public int pop() {
        int res = list.remove(list.size() - 1);
        if (lastMax == res) {
            lastMax = null;
        }
        return res;
    }

    public int getMax() {
        if (lastMax == null) {
            int max = 0;
            for (Integer value : list) {
                max = Math.max(max, value);
            }
            lastMax = max;
        }
        return lastMax;
    }

    public int getMax1() {
        return list.stream().max(Integer::compareTo).get();
    }
/*
    public static void main(String[] args) {
        Stack stack = new Stack();
        for (int i = 0; i < 1000000; i++) {
            int n = new Random().nextInt();
            stack.push(n);
        }

        int m = stack.getMax();
        System.out.println("max: " + m);

        for (int i = 0; i < 100000; i++) { //не правильно
            stack.pop();
        }
        int m1 = stack.getMax();
        System.out.println("max1: " + m1);
    }
    */
}
