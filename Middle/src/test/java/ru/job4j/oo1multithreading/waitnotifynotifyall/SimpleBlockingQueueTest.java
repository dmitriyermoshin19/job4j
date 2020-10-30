package ru.job4j.oo1multithreading.waitnotifynotifyall;

import org.junit.Test;

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
}