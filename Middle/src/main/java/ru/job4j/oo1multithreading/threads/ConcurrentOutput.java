package ru.job4j.oo1multithreading.threads;

public class ConcurrentOutput {
    public static void main(String[] args) {
        Thread another1 = new Thread(
                () -> System.out.println("anather1: " + Thread.currentThread().getName())
        );
        Thread another = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("anather: " + Thread.currentThread().getName());
                    }
                }
        );
        another1.start();
        another.start();
        another1.run();
        System.out.println(Thread.currentThread().getName());
    }
}
