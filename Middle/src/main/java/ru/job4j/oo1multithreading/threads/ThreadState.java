package ru.job4j.oo1multithreading.threads;

public class ThreadState {

    private static void printThreadState(Thread thread) {
        System.out.format("%s - %s\n", thread.getName(), thread.getState());
    }

    public static void main(String[] args) {
        Thread first = new Thread(
                () -> { }, "First thread"
        );
        Thread second = new Thread(
                () -> { }, "Second thread"
        );
        printThreadState(first);
        printThreadState(second);
        first.start();
        second.start();
        while (first.getState() != Thread.State.TERMINATED || second.getState() != Thread.State.TERMINATED) {
            if (first.getState() != Thread.State.TERMINATED && second.getState() != Thread.State.TERMINATED) {
                printThreadState(first);
                printThreadState(second);
            }
            if (first.getState() == Thread.State.TERMINATED) {
                printThreadState(second);
            } else if (second.getState() == Thread.State.TERMINATED) {
                printThreadState(first);
            }
        }
        printThreadState(first);
        printThreadState(second);
        System.out.println("main thread: The program has finished");
    }
}
