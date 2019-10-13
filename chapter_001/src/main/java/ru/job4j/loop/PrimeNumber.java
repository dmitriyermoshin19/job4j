package ru.job4j.loop;

public class PrimeNumber {
    public int calc(int finish) {
        int count = 0;
        for (int num = 2; num <= finish; num++) {
            for (int index = 2;index < num ; index++) {
                CheckPrimeNumber a = new  CheckPrimeNumber();
                if ( a.check(num)){
                    count +=1;
                }

            }
        }
        return count;
    }
}
