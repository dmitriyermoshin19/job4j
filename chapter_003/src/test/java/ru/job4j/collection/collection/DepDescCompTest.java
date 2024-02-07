package ru.job4j.collection.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.lessThan;

public class DepDescCompTest {
    @Test
    public void compare() {
        int rsl = new DepDescComp().compare(
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void checkDepDescComp() {
        List<String> deps = Arrays.asList("K1/SK1", "K1/SK2", "K1/SK1/SSK1", "K1/SK1/SSK2", "K2/SK1/SSK1", "K2/SK1/SSK2");
        List<String> rst = Departments.fillGaps(deps);
        Departments.sortDesc(rst);
        assertThat(rst, is(Arrays.asList("K2", "K2/SK1", "K2/SK1/SSK2", "K2/SK1/SSK1", "K1", "K1/SK2", "K1/SK1", "K1/SK1/SSK2", "K1/SK1/SSK1")));
    }
}
