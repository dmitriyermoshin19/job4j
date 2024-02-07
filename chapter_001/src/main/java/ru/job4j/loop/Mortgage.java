package ru.job4j.loop;

public class Mortgage {
    public int year(int amount, int salary, double percent) {
        int year = 0;
        while (0 < amount) {
            amount = amount + (int) (amount * percent * 0.01) - salary;
            year++;
        }
        return year;
    }
}
