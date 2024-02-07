package ru.job4j.oo1.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NodeTest {
    Node<Integer> first = new Node<>(1);
    Node<Integer> two = new Node<>(2);
    Node<Integer> third = new Node<>(3);
    Node<Integer> four = new Node<>(4);

    @Test
    public void whenHasCycleInTheEndThenTrue() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertThat(Node.hasCycle(first), is(true));
    }

    @Test
    public void whenHasCycleInTheMiddleThenTrue() {
        first.next = two;
        two.next = third;
        third.next = two;
        four.next = null;
        assertThat(Node.hasCycle(first), is(true));
    }

    @Test
    public void whenHasCycleThenFalse() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = null;
        assertThat(Node.hasCycle(first), is(false));
    }
}
