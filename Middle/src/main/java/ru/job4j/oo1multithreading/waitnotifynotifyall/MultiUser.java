package ru.job4j.oo1multithreading.waitnotifynotifyall;

public class MultiUser {
    public static void main(String[] args) {
        Barrier barrier = new Barrier();
        Thread master = new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName() + " -1 started");
                    barrier.on();
                },
                "Master"
        );
        Thread slave = new Thread(
                () -> {
                    barrier.check();
                    System.out.println(Thread.currentThread().getName() + " -2 started");
                },
                "Slave"
        );
        slave.start();
        master.start();
    }
}
