package ru.job4j.oo1multithreading.threads;

public class Wait {
    public static void main(String[] args) {
        new Thread(
                () -> {
                    try {
                        for (int i = 1; i <= 100; i++) {
                            Thread.sleep(1000);
                            System.out.print("\rLoading : " + i  + "%");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        ).start();
    }
}
