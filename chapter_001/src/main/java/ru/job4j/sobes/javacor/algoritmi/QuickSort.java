package ru.job4j.sobes.javacor.algoritmi;

public class QuickSort {
    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high); // находим индекс опорного элемента
            quicksort(arr, low, pivotIndex - 1); // рекурсивно сортируем элементы меньше опорного
            quicksort(arr, pivotIndex + 1, high); // рекурсивно сортируем элементы больше опорного
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // выбираем опорный элемент
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j); // меняем элементы местами, чтобы поместить меньшие элементы перед опорным
            }
        }
        swap(arr, i + 1, high); // помещаем опорный элемент в правильную позицию
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 7, 6, 3};
        int n = arr.length;
        quicksort(arr, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
