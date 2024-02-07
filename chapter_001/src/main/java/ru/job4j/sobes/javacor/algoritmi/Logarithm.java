package ru.job4j.sobes.javacor.algoritmi;

/**
 * будет ли входящее число соответствовать
 * основанию 3 - ответ: да или нет.(число 3(основание) в какой то степени(логарифм) = входящее число)
 */
public class Logarithm {

    public static boolean match(int nam) {
        int i = 3;
        int count = 2;//первое умножение основания на основание = в квадрате
        while (i < nam) {
            i *= 3;
            if (i == nam) {
                System.out.println(count);
                return true;
            }
            count++;
        }
        return false;
    }

    static boolean match1(int input) {//для неточного числа это быстрее
        while (input > 1) {
            if (input % 3 != 0) {
                return false;
            }
            input /= 3;
        }
        return input == 1;
    }

    public static void main(String[] args) {
        int i = 81;//81 = 3 в степени 4
      System.out.println(Logarithm.match(i));
      System.out.println(Logarithm.match1(i));
    }
}
//Логарифм - это математическая операция, обратная операции возведения в степень.
// Он позволяет найти показатель(точный-с запятой) степени(логарифм), в которую нужно возвести
// определенное число (называемое основанием логарифма), чтобы получить другое число.

// Формальное определение логарифма может быть дано следующим образом:
//        Если a^x = b, где a - основание логарифма,
//        x - логарифм числа b по основанию a,
//        то запись x = log_a(b) является логарифмической формой для данного уравнения.

// log_2(10) приближенно равен 3.3219