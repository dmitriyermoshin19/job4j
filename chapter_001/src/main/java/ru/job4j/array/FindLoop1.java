package ru.job4j.array;

public class FindLoop1 {
    public static int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; data.length != index; index++) {
            if (data[index] == el) {
                rst = index;
            }
        }
        return rst;
    }

    public static int indexOf1(int[] data, int el, int start, int finish) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = start; finish >= index; index++) {
            if (data[index] == el) {
                rst = index;
            }
        }
        return rst;
    }
}
