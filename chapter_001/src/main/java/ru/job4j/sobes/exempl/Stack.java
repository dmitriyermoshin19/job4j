package ru.job4j.sobes.exempl;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Stack {
     private final List<Integer> list = new LinkedList<>();

     void push(int value) {
        list.add(value);
    }

     int pop() {
       return list.remove(list.size() - 1);
    }

     int getMax() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            int a = list.get(i);
            max = Math.max(max, a);
        }
        return max;
    }

    public static void main(String[] args) {
         Stack stack = new Stack();
        for (int i = 0; i < 100000000; i++) {
            int n = new Random().nextInt();
            stack.push(n);
        }

        int m = stack.getMax();
        System.out.println("max: " + m);

        for (int i = 0; i < 1000000; i++) {
            stack.pop();
        }
        int m1 = stack.getMax();
        System.out.println("max1: " + m1);
    }
}
