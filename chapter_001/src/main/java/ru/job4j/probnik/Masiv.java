package ru.job4j.probnik;

public class Masiv {
    public static void main(String[] args) {
      /*  int[] n = {1, 2, 3};
        for (int index = 0; index!=3; index++ ) {
            int a = n[index];
            System.out.println(a);
        }*/
        int[] n = {1, 2, 3};
        for (int index = 0; index != n.length; index++) {
            int d = n[index];
            System.out.println(d); // Arrays.toString(n)
        }
    }
}
