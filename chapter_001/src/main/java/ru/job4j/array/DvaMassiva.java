package ru.job4j.array;

public class DvaMassiva {
    public static int[] odinakovieChisla(int[] date, int[] date1) {
        int count = 0;
        int[] chisla = new int[3];
        for (int i = 0; i < date.length; i++) {
            for (int i1 = 0; i1 < date1.length; i1++) {
                if (date[i] == date1[i1]) {
                    chisla[count] = date[i];
                    count++;
                }
            }
        }
        return chisla;
    }

    public static void main(String[] args) {
        int[] a = {8, 4, 1, 0, 3};
        int[] b = {1, 2, 5, 9, 4, 0};
        int[] v = odinakovieChisla(a, b);
        System.out.println();
        for (int g = 0; g < v.length; g++) {
            System.out.print(v[g] + ",");
        }
    }
    /**
     public static void main(String[] args) {
     int[] a = {8, 4, 1, 0, 3};
     int[] b = {1, 2, 5, 9, 4, 0};
     int[] v = odinakovieChisla(a, b);
     System.out.println();
     for (int g = 0; g < v.length; g++) {
     System.out.print(v[g] + "4 1 0 - ");
     }
     }*/
}
