package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.oop.obiekti.Point;
import ru.job4j.oop.obiekti.Triangle;

public class TriangleTest {
    @Test
    public void whenExist() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 2);
        Triangle tri = new Triangle(a, b, c);
        double out = tri.area();
        double expected = 1.9999999999999993;
        Assert.assertEquals(expected, out,  0.01);
    }
}
