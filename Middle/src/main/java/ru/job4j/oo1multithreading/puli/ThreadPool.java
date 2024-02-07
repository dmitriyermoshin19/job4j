package ru.job4j.oo1multithreading.puli;

import ru.job4j.oo1multithreading.waitnotifynotifyall.SimpleBlockingQueue;
import java.util.LinkedList;
import java.util.List;

public class ThreadPool {
    private final int poolSize = Runtime.getRuntime().availableProcessors();
    private final List<Thread> poolListThread = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasksQueueRunnable = new SimpleBlockingQueue<>(poolSize);

    public ThreadPool() {
        this.initPool();
    }

    private void initPool() {
        for (int i = 0; i < poolSize; i++) {
            poolListThread.add(new Thread(() -> {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        tasksQueueRunnable.poll().run();
                    }
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            }));
        }
    }

    public void work(Runnable job) {
        tasksQueueRunnable.offer(job);
    }

    public void shutdown() {
        poolListThread.forEach(Thread::interrupt);
    }
}
