package ru.job4j.array;

public class Turn {
    public int[] back1(int[] array) {
        for (int index = 0; index != array.length/2; index++) {
            int temp = array[index];
            array[index]= array[array.length-index -1] ;
            array[array.length-index -1]= temp;
        }
        return array;
    }
    public int[] back(int[] array) {
        for (int index = 0; index != (array.length-1)/2; index++) {
            int temp = array[index];
            array[index]= array[array.length-index -1] ;
            array[array.length-index -1]= temp;
        }
        return array;
    }
}
