package ru.job4j.sobes.multitrading.startthread;

public class StartThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Hello, world");
            }
        });
        thread.setDaemon(true);//демон закрывается при завершении программы
        // (мейн-в нем нет ничего- сразу завершается программа, быстрее чем 1000млс),
        // поэтому ничего не выведет в консоль, если join не добавить
        // но обычный тред выполнит вывод в консоль, даже без join
        thread.start();
//        thread.join();
    }
}
