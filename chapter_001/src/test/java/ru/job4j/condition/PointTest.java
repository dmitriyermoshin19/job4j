package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void distance() {
        int x1 = 1;
        int y1 = 2;
        int x2 = 3;
        int y2 = 4;
        double expected = 2.8284271247461903;
        double out = Point.distance(x1, y1, x2, y2);
        Assert.assertEquals(expected, out,  0.01);
    }
}
