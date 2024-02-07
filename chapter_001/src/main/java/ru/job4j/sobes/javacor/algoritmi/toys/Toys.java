package ru.job4j.sobes.javacor.algoritmi.toys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * макс capacity
 * вернуть макс кол.игрушек
 * объем в сумме которых не больше макс капасити
 * вход - два массива:кубики и мячики
 * возвратить - массив
 */
public class Toys {

    public static int[] selectToys(int[] cubes, int[] balls, int maxCapacity) {
        Arrays.sort(cubes);
        Arrays.sort(balls);

        List<Integer> selectedToys = new ArrayList<>();
        int currentVolume = 0;

        int cubeIndex = 0;
        int ballIndex = 0;

        while (cubeIndex < cubes.length || ballIndex < balls.length) {
            //если закончились кубики, то MAX_VALUE и в if для кубиков не заходим
            int nextCube = (cubeIndex < cubes.length) ? cubes[cubeIndex] : Integer.MAX_VALUE;
            int nextBall = (ballIndex < balls.length) ? balls[ballIndex] : Integer.MAX_VALUE;

            if (nextCube < nextBall) {
                if (currentVolume + nextCube <= maxCapacity) {
                    selectedToys.add(nextCube);
                    currentVolume += nextCube;
                    cubeIndex++;
                } else {
                    break;
                }
            } else {
                if (currentVolume + nextBall <= maxCapacity) {
                    selectedToys.add(nextBall);
                    currentVolume += nextBall;
                    ballIndex++;
                } else {
                    break;
                }
            }
        }

        return selectedToys.stream().mapToInt(i -> i).toArray();//или проще можно в Integer:
            // selectedToys.toArray(new Integer[0])
    }

    public static void main(String[] args) {
        int[] cubes = {10, 5, 2, 8};
        int[] balls = {3, 7, 4};
        int maxCapacity = 15;

        int[] result = selectToys(cubes, balls, maxCapacity);

        System.out.println("Выбранные игрушки: " + Arrays.toString(result));
//        for (int toy : result) {
//            System.out.println(toy);
//        }
    }
}

