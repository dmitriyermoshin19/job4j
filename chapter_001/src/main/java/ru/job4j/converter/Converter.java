package ru.job4j.converter;

public class Converter {
    public static int rubleToEuro(int value) {
        return value / 70;
    }
    public static int euroToRuble(int value) {
        return value * 70;
    }

    public static int rubleToDollar(int value) {
        return value / 60;
    }
    public static int dollarToRuble(int value) {
        return value * 60;
    }

    public static void main(String[] args) {
        int euro = rubleToEuro(140);
        System.out.println("140 rubles are " + euro + " euro.");
        int ruble = euroToRuble(140);
        System.out.println("140 euro are " + ruble + " rubles.");

        int dollar = rubleToDollar(140);
        System.out.println("140 rubles are " + dollar + " dollars.");
        int ruble1 = dollarToRuble(140);
        System.out.println("140 dollars are " + ruble1 + " rubles.");

        // proverka
        int in = 140;
        int expected = 2;
        int out = rubleToEuro(in);
        boolean passed = expected == out;
        System.out.println("140 rubles are 2. Test result : " + passed);

        int in1 = 2;
        int expected1 = 140;
        int out1 = euroToRuble(in1);
        boolean passed1 = expected1 == out1;
        System.out.println("2 euro are 140. Test result : " + passed1);

        int in2 = 120;
        int expected2 = 2;
        int out2 = rubleToDollar(in2);
        boolean passed2 = expected2 == out2;
        System.out.println("120 rubles are 2. Test result : " + passed2);

        int in3 = 2;
        int expected3 = 120;
        int out3 = dollarToRuble(in3);
        boolean passed3 = expected3 == out3;
        System.out.println("2 dollars are 120. Test result : " + passed3);
    }
}
