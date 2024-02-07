package ru.job4j.sobes.multitrading.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Взаимоблокировки, вызванные динамическим порядком блокировок
 */
public class DeadlockTransfer extends Thread {
    Account fromAccount;
    Account toAccount;
    Amount amount;
    String fromAccounts;
    String toAccounts;

    public DeadlockTransfer(Account fromAccount,Account toAccount, Amount amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }
    public DeadlockTransfer(String fromAccount,String toAccount, Amount amount) {
        this.fromAccounts = fromAccount;
        this.toAccounts = toAccount;
        this.amount = amount;
    }

    @Override
    public void run() {
        try {
            transferMoney(fromAccount, toAccount, amount);
//            transferMoneys(fromAccounts, toAccounts, amount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Amount {
        int balance;

        public Amount(int balance) {
            this.balance = balance;
        }
    }

    static class Account extends ReentrantLock {
        int id;
        int balance;

        public Account(int id, int balance) {
            this.id = id;
            this.balance = balance;
        }

        public int getId() {
            return id;
        }

        public void debit(Amount amount) {
        }
        public void credit(Amount amount) {
        }
    }

    //    static volatile int countYes = 0;//почему то конечные данные расходятся с последними данными в потоках
private  static  AtomicInteger countNo1 = new AtomicInteger(0);
private  static  AtomicInteger countNo2 = new AtomicInteger(0);
//    static volatile int countNo2 = 0;//не точно даже считает
    private  static  AtomicInteger countYes = new AtomicInteger(0);
    private  static  AtomicInteger countAll = new AtomicInteger(0);
    public static void transferMoney(Account fromAccount, Account toAccount, Amount amount) throws Exception {
//        System.out.println(Thread.currentThread().getName());
        countAll.incrementAndGet();
        while (true) {//кол-во запущенных тредов должно соответствовать кол-ву удачных операций!
            //т.е каждый поток должен быть удачным - без осечек
            if (fromAccount.tryLock()) {
//            System.out.println("зашел в 1 лок"); //здесь вывод *срывает операции
                if (toAccount.tryLock()) {
//                System.out.println("зашел во 2 лок");
                    try {
                        if (Integer.compare(fromAccount.balance, amount.balance) < 0)
                            throw new Exception();
                        else {
                            fromAccount.debit(amount);
                            toAccount.credit(amount);
                            System.out.println("Yes");
                        }
                    /*} catch (Exception e) {
                        System.out.println("Exception:"+e);*/
                    } finally {
                        toAccount.unlock();
                        fromAccount.unlock();
                    System.out.println("finally ");
                    }
                    countYes.incrementAndGet();
                    break;//даже с ошибкой только здесь ставить правильно - не в finally и не в catch
                } else {
                    fromAccount.unlock();
//                System.out.println("операция не удалась взять 2ю блокировку для: " + Thread.currentThread().getName() + " cчетчик: " + ++DeadlockTransfer.countNo2);
                    countNo2.incrementAndGet();
//                ++countNo2;
                }
            } else {
//            System.out.println("операция не удалась даже взять 1ю блокировку для: " + Thread.currentThread().getName() + " cчетчик: " + countNo1.incrementAndGet());
                countNo1.incrementAndGet();
            }
        }

/*        synchronized (fromAccount) { //будет дедлок - одна транзакция займет fromAccount, а другая - toAccount
            synchronized (toAccount) {
                if (Integer.compare(fromAccount.balance, amount.balance) < 0)
                    throw new Exception();
                else {
                    fromAccount.debit(amount);
                    toAccount.credit(amount);
                }
            }
        }*/
    }

    public static void transferMoney1(Account fromAccount, Account toAccount, Amount amount) throws Exception {
        System.out.println(Thread.currentThread().getName());

        if (fromAccount.getId() < toAccount.getId()) {//некоторый порядок для устранения дедлока
            synchronized (fromAccount) { //
                synchronized (toAccount) {
                    if (Integer.compare(fromAccount.balance, amount.balance) < 0)
                        throw new Exception();
                    else {
                        fromAccount.debit(amount);
                        toAccount.credit(amount);
                    }
                }
            }
        } else {
            synchronized (toAccount) { //переворачиваем второй поток, чтобы был как первый
                synchronized (fromAccount) {
                    if (Integer.compare(fromAccount.balance, amount.balance) < 0)
                        throw new Exception();
                    else {
                        fromAccount.debit(amount);
                        toAccount.credit(amount);
                    }
                }
            }
        }
    }
    public static void transferMoneys(String fromAccount, String toAccount, Amount amount) throws Exception {
//        System.out.println(Thread.currentThread().getName());
        synchronized (fromAccount) { //будет дедлок - одна транзакция займет fromAccount, а другая - toAccount
//            System.out.println(fromAccount);//так даже не блоакирует сразу, а доп.методы врутри улучшают блокировку

            synchronized (toAccount) {
                System.out.println("Со стрингом");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Account myAccount = new Account(1,10);
        Account youAccount = new Account(2,20);
        for (int i = 0; i < 10; i++) {//может не быть дедлока пару раз при запуске
            new DeadlockTransfer(myAccount, youAccount, new Amount(10)).start();
            new DeadlockTransfer(youAccount, myAccount, new Amount(10)).start();
        }
/*        new DeadlockTransfer(myAccount, youAccount, new Amount(10)).start();
        new DeadlockTransfer(youAccount, myAccount, new Amount(10)).start();*/

        System.out.println("                    счетчик: - 1я:"+ countNo1 + ", 2я:" + countNo2
                + "   + "+countYes + "  Всего по счетчику:"+countAll
//                +" сумма:"+(countNo1.get()+countNo2.get()+countYes.get()) //не правильно считает что то
        );
        //показывает не последнее значение


/*        for (int i = 0; i < 100; i++) {
            new DeadlockTransfer("myAccount", "youAccount", new Amount(10)).start();
            new DeadlockTransfer("youAccount", "myAccount", new Amount(10)).start();
        }*/
/*        new DeadlockTransfer("myAccount", "youAccount", new Amount(10)).start();
        new DeadlockTransfer("youAccount", "myAccount", new Amount(10)).start();*/


        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();
        if (deadlockedThreads != null) {
            ThreadInfo[] threadInfo = threadMXBean.getThreadInfo(deadlockedThreads);
            for (ThreadInfo info : threadInfo) {
                System.out.println(info);
            }
        }
    }
}
