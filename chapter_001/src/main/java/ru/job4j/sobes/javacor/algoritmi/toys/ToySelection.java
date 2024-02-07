package ru.job4j.sobes.javacor.algoritmi.toys;

import java.util.Arrays;

/**
 * макс capacity
 * вернуть макс кол.игрушек
 * объем в сумме которых не больше макс капасити
 * вход - два массива:кубики и мячики
 * возвратить - массив
 */
public class ToySelection {

    public static int[] selectToys(int[] cubes, int[] balls, int maxCapacity) {
        Arrays.sort(cubes); // Сортировка массива кубиков по возрастанию
        Arrays.sort(balls); // Сортировка массива мячиков по возрастанию

        int cubeCount = 0;
        int ballCount = 0;
        int[] selectedToys = new int[cubes.length + balls.length];
        int currentIndex = 0;

        while (cubeCount < cubes.length && ballCount < balls.length) {
            if (cubes[cubeCount] <= balls[ballCount] && cubes[cubeCount] <= maxCapacity) {
                selectedToys[currentIndex] = cubes[cubeCount++];
            } else if (balls[ballCount] <= maxCapacity) {
                selectedToys[currentIndex] = balls[ballCount++];
            } else {
                break;
            }
            maxCapacity -= selectedToys[currentIndex++];
        }

        // Добавляем оставшиеся игрушки, если есть свободное место
        while (cubeCount < cubes.length && cubes[cubeCount] <= maxCapacity) {
            selectedToys[currentIndex] = cubes[cubeCount++];
            maxCapacity -= selectedToys[currentIndex++];
        }

        while (ballCount < balls.length && balls[ballCount] <= maxCapacity) {
            selectedToys[currentIndex] = balls[ballCount++];
            maxCapacity -= selectedToys[currentIndex++];
        }

        return Arrays.copyOf(selectedToys, currentIndex);//пересчет размера массива на меньший
    }

    public static void main(String[] args) {
        int[] cubes = {3, 2, 5, 4};
        int[] balls = {1, 6, 2, 4};
        int maxCapacity = 10;

        int[] selectedToys = selectToys(cubes, balls, maxCapacity);

        System.out.println("Выбранные игрушки: " + Arrays.toString(selectedToys));
    }
}
