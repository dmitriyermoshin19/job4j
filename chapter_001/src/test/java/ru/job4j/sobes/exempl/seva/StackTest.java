package ru.job4j.sobes.exempl.seva;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.sobes.javacor.seva.Stack;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StackTest {
    @Ignore
    @Test
    public void whenPushAndPop() {
        Stack stack = new Stack();
        int n = 7;
        int n1 = 1;
        int n2 = 4;
        int n3 = -70;
        int n4 = 1;
        int n5 = 25;
        stack.push(n);
        stack.push(n1);
        stack.push(n2);
        stack.push(n3);
        stack.push(n4);
        stack.push(n5);
        int result = stack.pop();
        assertThat(result, is(n5));
        result = stack.pop();
        assertThat(result, is(n4));
        result = stack.pop();
        assertThat(result, is(n3));
        result = stack.pop();
        assertThat(result, is(n2));
        result = stack.pop();
        assertThat(result, is(n1));
        result = stack.pop();
        assertThat(result, is(n));
    }

    @Test
    public void whenPushAndGetMax() {
        Stack stack = new Stack();
        int n = 7;
        int n1 = 1;
        int n2 = 4;
        stack.push(n);
        stack.push(n1);
        stack.push(n2);
        int result = stack.getMax();
        assertThat(result, is(n));
    }

    @Test
    public void whenGetMax1() {
        Stack stack = new Stack();
        int n = 7;
        int n1 = 1;
        int n2 = 4;
        stack.push(n);
        stack.push(n1);
        stack.push(n2);
        int result = stack.getMax1();
        assertThat(result, is(n));
    }

    @Test
    public void whenGetMax2() {
        Stack stack = new Stack();
        List<Integer> list = new ArrayList<>();
        int plus = 1000000;
        int v = 250000;
        for (int i = 0; i < plus; i++) {
            int n1 = new Random().nextInt();
            stack.push(n1);
            list.add(n1);
            //System.out.println("was result = stack.push(n1)() = "); - проверил добавляет
        }
        int result = stack.getMax();
        int max1 = list.stream().max(Integer::compare).get();
        System.out.println("was result = stack.getMax() = " + result);
        //  System.out.println(stack.pop() + "полследний удалил через поп");//все сходится
        System.out.println(list.get(plus - 1) + " -list.get(plus - 1)");
        assertThat(result, is(max1));

        int minus = plus - 500000;
        for (int i = plus - 1; i > minus; i--) {
            int last1 = stack.pop();
            int last = list.remove(i);//удаляю не с конца - важно, а в поп удаляет с конца
            //System.out.println(last + " -list.remove"); // сходится с поп
            //System.out.println(last1 + " -stack.pop");// сходится с лист с начала до конца
        }
        int size = stack.getSize();
        int lsize = list.size();
        //System.out.println(" - stack.getSize() = " + size);
        // System.out.println(" - lsize.getSize() = " + lsize);
        result = stack.getMax();// кто то не правильно считает, скорее этот
        System.out.println("was result = stack.getMax() = " + result);
        max1 = stack.getMax1();
        //max1 = list.stream().max(Integer::compare).get();
        assertThat(result, is(max1));
    }

    @Test
    public void whenGetMax3() {
        Stack stack = new Stack();
        int n = 5;
        int n1 = 5;
        int n2 = 5;
        stack.push(n);
        stack.push(n1);
        stack.push(n2);
        int result = stack.getMax();
        assertThat(result, is(n));
        stack.pop();
        stack.push(0);
        result = stack.getMax();
        assertThat(result, is(5));
    }
}