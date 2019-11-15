package ru.job4j.oop.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean run = true;
        int caunt = 11;
        System.out.println(caunt);
        while (run) {
            if (caunt == 0) {
                System.out.println(" win ");
                run = false;
                break;
            }
            System.out.print("Возьмите спички от 1 до 3 ");
            int select = Integer.valueOf(input.nextLine());

            if (select == 1 && caunt != 0 && select <= caunt) {
                caunt -= 1;
                System.out.println(caunt);
            } else if (select == 2 && caunt != 0 && select <= caunt) {
                caunt -= 2;
                System.out.println(caunt);
            } else if (select == 3 && caunt != 0 && select <= caunt) {
                caunt -= 3;
                System.out.println(caunt);
            }
        }
    }
}