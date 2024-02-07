package ru.job4j.oo1multithreading;

public class MasterSlaveBarrier {
    private boolean doMaster = true;

    public synchronized void tryMaster() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    if (doMaster) {
                        doneMaster();
                        doMaster = false;
                        notifyAll();
                    }
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
    }

    public void trySlave() {
        synchronized (this) {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    if (!doMaster) {
                        doneSlave();
                        doMaster = true;
                        notifyAll();
                    }
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void doneMaster() {
        System.out.println("Thread A");
    }

    public void doneSlave() {
        System.out.println("Thread B");
    }

    public static void main(String[] args) throws InterruptedException {
        MasterSlaveBarrier barrier = new MasterSlaveBarrier();
        Thread first = new Thread(barrier::tryMaster);
        Thread second = new Thread(barrier::trySlave);
        first.start();
        second.start();
        first.join();
        second.join();
    }
}
