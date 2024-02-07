package ru.job4j.oo1multithreading.puli;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindIndexTest {

    @Test
    public void sequenceFind() {
        final String[] array = {
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        final String value = "six";
        FindIndex<String> fi = new FindIndex<>();
        int result = fi.parallelFind(array, value);

        assertThat(result, is(5));
    }

    @Test
    public void parallelFind() {
        final String[] array = {
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
                "twenty", "twenty-one", "twenty-two"};
        final String value = "ten";
        FindIndex<String> fi = new FindIndex<>();
        int result = fi.parallelFind(array, value);

        assertThat(result, is(9));

    }
}