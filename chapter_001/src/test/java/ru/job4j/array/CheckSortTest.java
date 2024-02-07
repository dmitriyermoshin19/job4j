package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CheckSortTest {
    @Test
    public void whenStartWithPrefixThenTrue() {
        int[] input = {1, 2, 3, 4, 5};
        boolean result = CheckSort.check1(input);
        assertThat(result, is(true));
    }
}
