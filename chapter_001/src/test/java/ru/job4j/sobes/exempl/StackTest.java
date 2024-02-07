package ru.job4j.sobes.exempl;

import org.junit.Test;
import ru.job4j.sobes.exempl.Stack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StackTest {
    @Test
    public void whenPushAndPop() {
        Stack stack = new Stack();
        int n = 7;
        int n1 = 1;
        int n2 = 4;
        stack.push(n);
        stack.push(n1);
        stack.push(n2);
        int result = stack.pop();
        assertThat(result, is(n2));
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
}