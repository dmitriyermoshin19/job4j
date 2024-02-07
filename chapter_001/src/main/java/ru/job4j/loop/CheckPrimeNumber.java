package ru.job4j.loop;

public class CheckPrimeNumber {
    public boolean check(int num) {
        boolean prime = true;
        for (int index = 2; index < num; index++) {
            if ((num % index) == 0) {
                prime = false;
                break;
            }
        }
        return prime;
    }
}
