package ru.job4j.oo1.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayListTest {
    ArrayList<Integer> list = new ArrayList<>();

    @Before
    public void setUp() {
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
    }

    @Test
    public void whenAddAndGet() {
        assertThat(list.size(), is(10));
        list.add(10);
        assertThat(list.size(), is(20));
        assertThat(list.get(10), is(10));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenIterator() {
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(0));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        list.add(10);
        it.next();
    }
}
