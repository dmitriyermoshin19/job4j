package ru.job4j.oo1multithreading.waitnotifynotifyall;

import org.junit.Test;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleBlockingQueueTest {

    @Test
    public void test() throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(3);
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                queue.offer(i);
                System.out.println("offer:" + i);
            }
        }, "Producer");
        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                Integer value = queue.poll();
                System.out.println("poll: " + value);
            }
        });
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        assertThat(queue.getQueue().size(), is(0));
    }

    @Test
    public void whenFetchAllThenGetIt() throws InterruptedException {
        final CopyOnWriteArrayList<Integer> buffer = new CopyOnWriteArrayList<>();
        final SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(3);
        Thread producer = new Thread(
                () -> {
                    for (int i = 0; i < 5; i++) {
                        queue.offer(i);
                    }
                }
        );
        producer.start();
        Thread consumer = new Thread(
                () -> {
                    try {
                        while (queue.getQueue().size() > 0 || !Thread.currentThread().isInterrupted()) {
                            if (queue.getQueue().size() > 0) {
                                buffer.add(queue.poll());
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }
        );
        consumer.start();
        producer.join();
        consumer.interrupt();
        consumer.join();
        assertThat(buffer, is(Arrays.asList(0, 1, 2, 3, 4)));
    }
}