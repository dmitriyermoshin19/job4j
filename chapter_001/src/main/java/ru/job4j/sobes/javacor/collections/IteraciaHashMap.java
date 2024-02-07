package ru.job4j.sobes.javacor.collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class IteraciaHashMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Key1", 1);
        map.put("Key2", 2);
        map.put("Key3", 3);


        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
