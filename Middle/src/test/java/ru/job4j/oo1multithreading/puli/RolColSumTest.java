package ru.job4j.oo1multithreading.puli;

import org.junit.Test;
import java.util.concurrent.ExecutionException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RolColSumTest {
    private static final int[][] MATRIX = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    @Test
    public void whenSum() {
        RolColSum.Sums[] sums = RolColSum.sum(MATRIX);
        assertThat(sums[0].rowSum, is(6));
        assertThat(sums[0].colSum, is(12));
        assertThat(sums[1].rowSum, is(15));
        assertThat(sums[1].colSum, is(15));
        assertThat(sums[2].rowSum, is(24));
        assertThat(sums[2].colSum, is(18));
    }

    @Test
    public void whenAsyncSum() throws ExecutionException, InterruptedException {
        RolColSum.Sums[] sums = RolColSum.asyncSum(MATRIX);
        assertThat(sums[0].rowSum, is(6));
        assertThat(sums[0].colSum, is(12));
        assertThat(sums[1].rowSum, is(15));
        assertThat(sums[1].colSum, is(15));
        assertThat(sums[2].rowSum, is(24));
        assertThat(sums[2].colSum, is(18));
    }
}