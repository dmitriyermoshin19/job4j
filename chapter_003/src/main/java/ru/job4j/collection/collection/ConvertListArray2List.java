package ru.job4j.collection.collection;

import java.util.LinkedList;
import java.util.List;

public class ConvertListArray2List {
    public List<Integer> toList(List<int[]> listArray) {
        List<Integer> list = new LinkedList<>();
        for (int[] row : listArray) {
            for (int cell : row) {
                list.add(cell);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<int[]> listArray = new LinkedList<>();
        listArray.add(new int[]{1, 2});
        listArray.add(new int[]{3, 4, 5, 6});
        List<Integer> rsl = new ConvertListArray2List().toList(listArray);
        for (Integer row : rsl) {
            System.out.print(row + " ");
        }
    }
}
