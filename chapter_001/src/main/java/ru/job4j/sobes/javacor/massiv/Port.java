package ru.job4j.sobes.javacor.massiv;

import java.util.ArrayList;
import java.util.List;

public class Port {
//    String p =  new Class.Parent().name;
    /**
     * Метод, преобразовывающий массив строк indexes в массив
     * последовательностей чисел;
     * @param indexes
     * @return
     */
    Integer[] getMassiv(String[] indexes) {
        List<Integer> buf = new ArrayList<>();
        for (String index : indexes) {
            String[] arrayFromString = index.split(",");
            keep(arrayFromString, buf);
        }
        Integer[] res = new Integer[buf.size()];
        buf.toArray(res);
        return res;
    }

    /**
     *  Метод, возвращающий всевозможные уникальные упорядоченные группы
     * элементов полученных массивов чисел.
     *  {"1,3-5", "2", "3-4"} преобразуется в следующий массив чисел:
     * {[1, 2, 3], [1, 2, 4], [3, 2, 3], [3, 2, 4], [4, 2, 3], [4, 2, 4], [5, 2, 3], [5, 2, 4]}
     * не получилось
     * @param array
     * @return
     */
    List< List<Integer>> getMatrix(String[] array) {
        int[][] res = new int [3][4];
        List< List<Integer>> bufGeneral = new ArrayList<>();
        for (int i = 0;i < array.length;i++) {
            String[] arrayFromString = array[i].split(",");
            List<Integer> buf = new ArrayList<>();
            keep(arrayFromString, buf);
            bufGeneral.add(buf);
        }
        int i = 0;
        List<Integer> listGeneral = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        for (List<Integer> list : bufGeneral) {
            if(i < list.size()) {
                list1.add(list.get(i));
            } else {

            }
        }
        i++;
        return bufGeneral;
    }

    void keep(String[] arrayFromString, List<Integer> buf) {
        for (String n : arrayFromString) {
            if(!n.contains("-")) {
                buf.add(Integer.parseInt(n));
            } else {
                Integer a = Integer.parseInt(n.substring(0,1));
                Integer b = Integer.parseInt(n.substring(n.length()-1));
                buf.add(a);
                while (++a<b) {
                    buf.add(a);
                }
                buf.add(b);
            }
        }
    }
    public static void main(String[] args) {
        String[] indexes = {"1,3-5", "2", "3-4"};
        Port port = new Port();
//        Integer[] m = port.getMassiv(indexes);
//        System.out.println(m);
//        for (int i : m) {
//            System.out.println(i);
//        }
        List< List<Integer>> m = port.getMatrix(indexes);
        for (List<Integer> list : m) {
            System.out.println(list);
        }
    }
}
