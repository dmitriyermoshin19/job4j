package ru.job4j.oop.tracker;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {
    @Test
    public void whenInvalidInput() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "1"})
        );
        input.askInt("Enter", 1);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Please enter validate data again ")
                .toString();
        assertThat(new String(mem.toByteArray()), is(expect));
        System.setOut(out);
    }
}
