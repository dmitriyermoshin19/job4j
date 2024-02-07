package ru.job4j.loop;

public class PrimeNumber {
    public int calc(int finish) {
        int count = 0;
        CheckPrimeNumber a = new CheckPrimeNumber();
        for (int num = 2; num <= finish; num++) {
            if (a.check(num)) {
                count += 1;
            }
        }
        return count;
    }
}
