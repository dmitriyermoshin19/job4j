package ru.job4j.oo1.list;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LinkedListTest {
    LinkedList<Integer> list = new LinkedList<>();

    @Before
    public void setUp() {
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
    }

    @Test
    public void whenAddAndGet() {
        assertThat(list.getSize(), is(5));
        list.add(5);
        assertThat(list.getSize(), is(6));
        assertThat(list.get(0), is(5));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIterator() {
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(0));
        assertThat(it.hasNext(), is(false));
        assertThat(it.next(), is(new NoSuchElementException()));
        assertThat(it.next(), is(new ConcurrentModificationException()));
    }
}
