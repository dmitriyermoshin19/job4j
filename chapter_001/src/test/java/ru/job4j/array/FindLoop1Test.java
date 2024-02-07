package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoop1Test {
    @Test
    public void whenArrayHasLength5Then0() {
        int[] input = new int[]{5, 10, 3};
        int value = 5;
        int result = FindLoop1.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHasLength5Then1fals() {
        int[] input = new int[]{5, 10, 3};
        int value = 5;
        int result = FindLoop1.indexOf(input, value);
        int expect = 0; // должно стоят 1 т.к. это фолс в условии
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHasLength3Then2() {
        int[] input = new int[]{5, 10, 3};
        int value = 3;
        int result = FindLoop1.indexOf(input, value);
        int expect = 2;
        assertThat(result, is(expect));
    }

    @Test
    public void whenFind3() {
        int[] input = new int[]{5, 2, 10, 2, 4};
        int value = 2;
        int start = 2;
        int finish = 4;
        int result = FindLoop1.indexOf1(input, value, start, finish);
        int expect = 3; // ячейка
        assertThat(result, is(expect));
    }

    @Test
    public void whenFind2() {
        int[] input = new int[]{5, 2, 10, 2, 4};
        int value = 10;
        int start = 2;
        int finish = 4;
        int result = FindLoop1.indexOf1(input, value, start, finish);
        int expect = 2;
        assertThat(result, is(expect));
    }

    @Test
    public void whenFind5fals() {
        int[] input = new int[]{5, 2, 10, 2, 4};
        int value = 10;
        int start = 2;
        int finish = 4;
        int result = FindLoop1.indexOf1(input, value, start, finish);
        int expect = 2; // изменил было 0 чтобы соответствовало условию
        assertThat(result, is(expect));
    }
}
