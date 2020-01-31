package ru.job4j.oo1.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleStackTest {
    SimpleStack<Integer> stack = new SimpleStack<>();

    @Before
    public void setUp() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @Test
    public void whenPoll() {
        assertThat(stack.poll(), is(3));
        assertThat(stack.poll(), is(2));
        assertThat(stack.poll(), is(1));
    }

    @Test
    public void whenPushAndPoll() {
        stack.push(4);
        stack.push(5);
        assertThat(stack.poll(), is(5));
        assertThat(stack.poll(), is(4));
    }
}
