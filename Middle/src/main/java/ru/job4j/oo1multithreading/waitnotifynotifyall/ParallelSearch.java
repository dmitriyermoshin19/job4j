package ru.job4j.oo1multithreading.waitnotifynotifyall;

public class ParallelSearch {

    public static void main(String[] args) throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(1);
        final Thread consumer = new Thread(
                () -> {
                    while (!Thread.currentThread().isInterrupted()) {
                        System.out.println(Thread.currentThread().getName() + " poll  " + queue.poll());
                    }
                },
                "consumer"
        );
        consumer.start();
        final Thread producer = new Thread(
                () -> {
                    for (int index = 0; index != 3; index++) {
                        System.out.println(Thread.currentThread().getName() + " offer " + index);
                        queue.offer(index);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                },
                "producer"
        );
        producer.start();
        producer.join();
        consumer.interrupt();
    }
}
