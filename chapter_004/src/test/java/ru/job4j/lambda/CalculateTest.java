package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CalculateTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Calculate function = new Calculate();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenKvadratFunctionThenKvadratResults() {
        Calculate function = new Calculate();
        List<Double> result = function.diapason(2, 5, x -> 2 * Math.pow(x, 2));
        List<Double> expected = Arrays.asList(8D, 18D, 32D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenLogFunctionThenLogResults() {
        Calculate function = new Calculate();
        List<Double> result = function.diapason(1, 4, x -> Math.log(x));
        List<Double> expected = Arrays.asList(0.0, 0.6931471805599453, 1.0986122886681098);
        assertThat(result, is(expected));
    }
}
