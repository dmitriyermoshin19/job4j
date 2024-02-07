package ru.job4j.sobes.javacor.algoritmi;

import java.util.*;

public class AnagramSorter {

    public static String[][] groupAnagrams(String[] words) {
        Map<String, List<String>> anagramGroups = new HashMap<>();
        for (String word : words) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray); // сортируем буквы в слове
            String sortedWord = new String(charArray);
            List<String> group = anagramGroups.getOrDefault(sortedWord, new ArrayList<>());
            group.add(word);//сортируем каждое слово по ключу
            anagramGroups.put(sortedWord, group);
        }
        String[][] result = new String[anagramGroups.size()][];
        int i = 0;
        for (List<String> group : anagramGroups.values()) {
            String[] array = group.toArray(new String[0]);
            Arrays.sort(array); // сортируем массив анаграмм
            result[i++] = array;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"eat", "tea", "ate", "tan", "bat", "nat"};
        String[][] result = groupAnagrams(words);
        for (String[] group : result) {
            System.out.println(Arrays.toString(group));
        }
    }
}

