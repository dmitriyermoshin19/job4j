package ru.job4j.oo1multithreading.threads;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * поток для скачивания
 * принимает адрес файла для скачивания
 * и максимально допустимую скорость для скачивания за одну секунду в килобайтах.
 * алгоритм следующий:
 * засекаем время, скачиваем в буфер согласно мах скорости,
 * если скачали быстрее чем за секунду - ждем до конца секунды
 */

public class FileDownload implements Runnable {
    private final String url;
    private final int speed;

    public FileDownload(String url, int speed) {
        this.url = url;
        this.speed = speed;
    }

    @Override
    public void run() {
        System.out.println("Max speed download: " + speed + " kB/sek");
        int downloaded = 0;
        int lentch = 1024 * speed;
        long start = System.currentTimeMillis();
        long timeStart = start;
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream out = new FileOutputStream("pom_tmp.txt")) {
            byte[] dataBuffer = new byte[lentch];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, lentch)) != -1) {
                downloaded += bytesRead;
                out.write(dataBuffer, 0, bytesRead);
                if ((System.currentTimeMillis() - timeStart) < 1000L) {
                    try {
                        Thread.sleep(1000L - (System.currentTimeMillis() - timeStart));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                    System.out.printf(" %d kb loaded \r", downloaded / 1024);
                    timeStart = System.currentTimeMillis();
            }
            System.out.printf(" %d kb all download", downloaded / 1024);
            System.out.println();
            System.out.printf(" %d s download time", (System.currentTimeMillis() - start) / 1000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String url = args[0];
        int speed = Integer.parseInt(args[1]);
        try {
            Thread download = new Thread(new FileDownload(url, speed));
            download.start();
            download.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
