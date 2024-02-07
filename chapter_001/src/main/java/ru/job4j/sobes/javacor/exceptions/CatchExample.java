package ru.job4j.sobes.javacor.exceptions;

public class CatchExample {
    public static class MyException extends Exception {

        public MyException(String msg) {
            super(msg);
        }
    }

    public static void main(String[] args) throws MyException {
        try {
            throw new MyException("some msg"); //не выводится сама по себе на консоль,чт вывести надо ее поймать
        } catch (MyException e) {    //если эту убрать, то поймает следующая - родитель
            System.out.println("System.out.println some msg1: + е = " + e);
            e.printStackTrace();// красными буквами пишет в трейс ошибку и ее сообщение в ней some msg
        } catch (Exception e) {
            System.out.println("some msg2"); //не выведится на консоль - не та ошибка
        }
    }

}
