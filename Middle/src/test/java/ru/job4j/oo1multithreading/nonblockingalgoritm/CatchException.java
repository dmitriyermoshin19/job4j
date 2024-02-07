package ru.job4j.oo1multithreading.nonblockingalgoritm;

import org.junit.Test;
import org.junit.Assert;
import static org.hamcrest.Matchers.is;
import java.util.concurrent.atomic.AtomicReference;

public class CatchException {
    @Test
    public void whenThrowException() throws InterruptedException {
        AtomicReference<Exception> ex = new AtomicReference<>();
        Thread thread = new Thread(
                () -> {
                    try {
                        throw new RuntimeException("Throw Exception in Thread");
                    } catch (Exception e) {
                        ex.set(e);
                    }
                }
        );
        thread.start();
        thread.join();
        Assert.assertThat(ex.get().getMessage(), is("Throw Exception in Thread"));
    }
}
