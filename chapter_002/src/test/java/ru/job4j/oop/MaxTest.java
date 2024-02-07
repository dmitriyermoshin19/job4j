package ru.job4j.oop;

import org.junit.Test;
import ru.job4j.oop.obiekti.Max;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2To3Then3() {
        int result = Max.max(1, 2, 3);
        assertThat(result, is(3));
    }

    @Test
    public void whenMax5To2To3Then5() {
        int result = Max.max(5, 2, 3);
        assertThat(result, is(5));
    }

    @Test
    public void whenMax5To2To3To4Then5() {
        int result = Max.max(5, 2, 3, 4);
        assertThat(result, is(5));
    }

    @Test
    public void whenMax1To2To3To4Then5() {
        int result = Max.max(1, 2, 3, 5);
        assertThat(result, is(5));
    }
}
