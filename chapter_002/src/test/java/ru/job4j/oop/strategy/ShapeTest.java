package ru.job4j.oop.strategy;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ShapeTest {
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(
                square.draw(),
                is(
                        new StringBuilder()
                                .append(" +++++" + System.lineSeparator())
                                .append("+     +" + System.lineSeparator())
                                .append("+     +" + System.lineSeparator())
                                .append(" +++++")
                                .toString()
                )
        );
    }
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append("+" + System.lineSeparator())
                                .append("+  +" + System.lineSeparator())
                                .append("+     +" + System.lineSeparator())
                                .append("++++++++")
                                .toString()
                )
        );
    }
}
