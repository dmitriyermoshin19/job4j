package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest {
    @Test
    public void whenSecondMax() {
        SqMax check = new SqMax();
        int result = check.max(4, 2, 8, 1);
        assertThat(result, is(8));
    }
}
