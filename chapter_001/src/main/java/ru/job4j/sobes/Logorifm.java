package ru.job4j.sobes;

/**
 * будет ли входящее число(логарифм) соответствовать
 * основанию 3 - ответ: да или нет.
 */
public class Logorifm {

    public static boolean match(int nam) {
        int i = 3;
        while (i < nam) {
            i = i * 3;
            if (i == nam) {
                return true;
            }
        }
      return false;
    }

    static boolean match1(int input) {
        while (input > 1) {
            if (input % 3 != 0) {
                return false;
            }
            input = input / 3;
        }
        return input == 1;
    }

    public static void main(String[] args) {
        int i = 81;
      System.out.println(Logorifm.match(i));
      System.out.println(Logorifm.match1(i));
    }
}
