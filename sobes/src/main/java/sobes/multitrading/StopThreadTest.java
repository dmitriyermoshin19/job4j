package sobes.multitrading;

import java.util.concurrent.TimeUnit;

public class StopThreadTest {
    private static boolean stopRequested; // без volatile зависнет

    public static void main(String[] args) throws InterruptedException {
        Thread backGroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                i++;
//                System.out.println(i);
            }
        });
        backGroundThread.start();// join  не нужен, чтобы продолжать, нужен чтобы дожидаться завершения!!!
       // backGroundThread.join();//с ним зависнит - будет дожидаться окончания потока
        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
