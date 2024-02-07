package ru.job4j.oo1multithreading.waitnotifynotifyall;

public class CountBarrier {
    private final Object monitor = this;
    private final int total;
    private int count;

    public CountBarrier(final int total) {
        this.total = total;
    }

    public synchronized void count() {
        count++;
        monitor.notifyAll();
    }

    public synchronized void await() {
        while (count != total) {
            System.out.println("await wait");
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String... args) {
        int total = 10;
        CountBarrier countBarrier = new CountBarrier(total);
        Thread threadAwait = new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName() + " start");
                    countBarrier.await();
                    System.out.println(Thread.currentThread().getName() + " complete");
                },
                "threadAwait"
        );
        threadAwait.start();
        Thread count1 = new Thread(
                    () -> {
                        for (int i = 0; i < total / 2; i++) {
                            countBarrier.count();
                            System.out.println(Thread.currentThread().getName() + "1++");
                        }
                    },
                "count");
        Thread count2 = new Thread(
                () -> {
                    for (int i = 0; i < total / 2; i++) {
                        countBarrier.count();
                        System.out.println(Thread.currentThread().getName() + "2++");
                    }
                },
                "count");
        count1.start();
        count2.start();
    }
}
