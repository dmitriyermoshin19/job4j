package ru.job4j.oo1.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleQueueTest {
    SimpleQueue<Integer> queue = new SimpleQueue<>();

    @Before
    public void setUp() {
        queue.push(1);
        queue.push(2);
        queue.push(3);
    }

    @Test
    public void whenPoll() {
        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is(2));
        assertThat(queue.poll(), is(3));
    }

    @Test
    public void whenPushAndPoll() {
        queue.push(4);
        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is(2));
        queue.push(5);
        queue.push(6);
        assertThat(queue.poll(), is(3));
        assertThat(queue.poll(), is(4));
        assertThat(queue.poll(), is(5));
        assertThat(queue.poll(), is(6));
    }
}
