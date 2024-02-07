package sobes.javacor.exceptions;

public class CatchExample {
    public static class MyException extends Exception {

        public MyException(String msg) {
            super(msg);
        }
    }

    static void example1() {
        try {
            throw new MyException("some msg"); //не выводится(без catch даже не скомпилируется) сама по себе на консоль,чт вывести надо ее поймать
        } catch (MyException e) {    //если эту убрать, то поймает следующая - родитель
            System.out.println("System.out.println some msg1: + е = <" + e + ">");
//            e.printStackTrace();// красными буквами пишет в трейс исключение(сам класс исключения) и его сообщение в ней: some msg
        } catch (Exception e) { //родитель - класс Exception: class MyException extends Exception
            System.out.println("some msg2"); //не выведется на консоль - не та ошибка
            e.printStackTrace();
        }
    }

    static int example() {
        try {
            return 10/0;
        } catch (Exception e) {
            System.out.println(e);
            return Integer.MAX_VALUE;//поймает эту ошибку, но return перепишет в файнали
        } finally {
            return Integer.MIN_VALUE;//перезаписывает все результаты на -2147483648
        }
    }

    public static void main(String[] args) {
        example1();
//        int n = example();
//        System.out.println(n);
    }

}
