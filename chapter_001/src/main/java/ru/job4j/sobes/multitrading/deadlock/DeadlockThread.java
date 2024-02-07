package ru.job4j.sobes.multitrading.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Взаимоблокировки, вызванные порядком наложения блокировок.
 */
public class DeadlockThread implements Runnable {

    private Integer r1; //монитор только у объекта - не у примитива
    private Integer r2;
    String s1;
    String s2;

    public DeadlockThread(Integer r1, Integer r2) {
        this.r1 = r1;
        this.r2 = r2;
    }

    public DeadlockThread(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    void get(String s1, String s2) {
        if (s1.hashCode() < s2.hashCode()) {
            synchronized (s1) {
                System.out.println(Thread.currentThread().getName() + " захватил ресурс: r1 =  " + s1);
                synchronized (s2) { // синхронизация внутри первой синхронизации
                    // - будет дедлок - Взаимоблокировки, вызванные порядком наложения блокировок
                    System.out.println(Thread.currentThread().getName() + " захватил ресурс: " + s2);
                }
            }
        } else {
            synchronized (s2) {
                System.out.println(Thread.currentThread().getName() + " захватил ресурс: r1 =  " + s1);
                synchronized (s1) { // синхронизация внутри первой синхронизации
                    // - будет дедлок - Взаимоблокировки, вызванные порядком наложения блокировок
                    System.out.println(Thread.currentThread().getName() + " захватил ресурс: " + s2);
                }
            }
        }

    }
    @Override
    public void run() {
        try {
            get1(s1, s2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        void get1(String s1, String s2) {
//            System.out.println(Thread.currentThread().getName());//ухудшает блокировку
            synchronized (s1) {
            System.out.println(Thread.currentThread().getName() + " захватил ресурс: r1 =  " + s1);// улучшает блокировку

            try {   // улучшает блокировку. не дает дальше проскочить до проверки дедлока через код
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (s2) { // синхронизация внутри первой синхронизации
                // - будет дедлок - Взаимоблокировки, вызванные порядком наложения блокировок
                System.out.println(Thread.currentThread().getName() + " захватил ресурс: " + s2);
            }
        }
/*        synchronized (s2) { // синхронизация вне первой синхронизации
            System.out.println(Thread.currentThread().getName() + " захватил ресурс s2: " + s2);
        }*/
    }

    public static void main(String[] args) {
    /*    final Integer r3 = 10;
        final Integer r4 = 15;*/
                                          //одинаковые объекты захватываются в разных потоках
        DeadlockThread threadR1R2 = new DeadlockThread("10", "15"); // Thread-0
//        DeadlockThread threadR2R1 = new DeadlockThread("15", new String("10")); // Thread-1 - ссылка на др.объект-блокирвки не будет
        DeadlockThread threadR2R1 = new DeadlockThread("15", "10"); // Thread-1

        new Thread(threadR1R2).start();
        new Thread(threadR2R1).start();
        for (int i = 0;i<100;i++) {
            new Thread(threadR1R2).start();
            new Thread(threadR2R1).start();
        }

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();
        if (deadlockedThreads != null) {
            ThreadInfo[] threadInfo = threadMXBean.getThreadInfo(deadlockedThreads);
            for (ThreadInfo t : threadInfo) {
                System.out.println(t);
            }
        }
    }
}
