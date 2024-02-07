package ru.job4j.oo1multithreading.threads;

public class Wait {
    public static void main(String[] args) throws InterruptedException {
        Thread progress = new Thread(
                () -> {
                    int i = 1;
                    while (!Thread.currentThread().isInterrupted()) {
                        try {
                            Thread.sleep(1000);
                            System.out.print("\rLoading : " + i + "%");
                        } catch (InterruptedException e) {
                            System.out.println();
                            System.out.println(Thread.currentThread().isInterrupted());
                            System.out.println(Thread.currentThread().getState());
                            Thread.currentThread().interrupt();
                        }
                        i++;
                    }
                }
        );
        progress.start();
        Thread.sleep(10000);
        progress.interrupt();
        progress.join();
    }
}
