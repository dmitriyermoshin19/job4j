package ru.job4j.sobes.multitrading.deadlock;

/**
 * Взаимоблокировки, вызванные порядком наложения блокировок.
 */
public class Deadlock {
    private final static Object left = new Object();
    private final static Object right = new Object();
  //  два одинаковых объекта в обоих методах:
    public static void leftRight() { // блокировка внутри блокировки - дедлок
        synchronized (left) { //первый поток захватил left
            System.out.println("зашел " + Thread.currentThread().getName());
            synchronized (right) { //здесь первый поток ждет right, захваченный вторым потоком
                System.out.println("нет дедлоку 1");
            }
        }

/*        synchronized (right) {
            System.out.println("нет дедлоку 1 right = " + right);
        }*/
    }

    public static void rightLeft() {
        synchronized (right) { //второй поток захватил right
            System.out.println("зашел " + Thread.currentThread().getName());
            synchronized (left) {// здесь второй поток ждет left, захваченный первым потоком
                System.out.println("нет дедлоку 2 left = " + left);
            }
        }
    }

    public static void main(String[] args) {
        new Thread(Deadlock::leftRight).start();
        new Thread(Deadlock::rightLeft).start();
    }
}
