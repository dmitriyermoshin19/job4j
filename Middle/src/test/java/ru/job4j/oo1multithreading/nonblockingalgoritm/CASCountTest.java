package ru.job4j.oo1multithreading.nonblockingalgoritm;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CASCountTest {

    @Test
    public void whenDoubleIncrementBy3ThreadsThenReturn6() throws InterruptedException {
        CASCount<Integer> counter = new CASCount<>();
        Thread t1 = new Thread(
                () -> {
                    counter.increment();
                    counter.increment();
                }
        );
        t1.start();
        Thread t2 = new Thread(
                () -> {
                    counter.increment();
                    counter.increment();
                }
        );
        t2.start();
        Thread t3 = new Thread(
                () -> {
                    counter.increment();
                    counter.increment();
                }
        );
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        assertThat(counter.get(), is(6));
    }
}
