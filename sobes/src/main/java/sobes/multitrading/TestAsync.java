package sobes.multitrading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class TestAsync {
    private Object lock = new Object();

    public void print() throws InterruptedException, ExecutionException {
        CompletableFuture.runAsync(() -> {
            synchronized (lock) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("1");
            }
        });

        //Thread.sleep(100); //осн.поток спит не долго, ассинхронные операции прерываются без проблем

        lock = new Object();

        CompletableFuture.runAsync(() -> { //эта операция тоже может не успеть выполнится, если не задержать осн.поток
            synchronized (lock) {
                System.out.println("2");//без задержки ниже иногда может вывестись
            }
        });//.get();
        //Thread.sleep(100);//с задержкой осн.потока всегда будет выполняться предидущая асинхр.операция
    }
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        new TestAsync().print();
    }
}
