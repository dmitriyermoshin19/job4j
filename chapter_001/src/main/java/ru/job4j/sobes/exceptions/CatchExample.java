package ru.job4j.sobes.exceptions;

public class CatchExample {
    public static class MyException extends Exception {

        public MyException(String msg) {
            super(msg);
        }
    }

        public static void main(String[] args) {
            try {
                throw new MyException("some msg"); //не выводится сама по себе на консоль
            } catch (MyException e) {
                System.out.println("some msg1: " + e);
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("some msg2"); //не выведится на консоль - не та ошибка
            }
        }

}
