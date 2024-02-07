package ru.job4j.sobes.javacor.massiv;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MassivToVlozeniyMassiv {
    //Дан массив строк, необходимо сгруппировать анаграммы
//Слово X вляется анаграммой Y, если одно может быть получено из другого перестановкой букв
//В итоговом массиве каждый массив анаграмм должен быть отсортирован в лексикографическом порядке
    public static String[][] groupAnagrams(String[] words) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String word : words) { //неотсортированную строчку массива превращаем в отсортированную
            char[] wordChars = word.toCharArray();
            Arrays.sort(wordChars);
            String sortedWord = new String(wordChars);
            if (anagrams.containsKey(sortedWord)) { //она становится ключом в мапе
                anagrams.get(sortedWord).add(word);
            } else {
                List<String> anagramGroup = new ArrayList<>();
                anagramGroup.add(word);
                anagrams.put(sortedWord, anagramGroup);
            }
        }
        String[][] result = new String[anagrams.size()][];
        int i = 0;
        for (List<String> anagramGroup : anagrams.values()) {
            anagramGroup.sort(String::compareTo);
            result[i++] = anagramGroup.toArray(new String[anagramGroup.size()]);
        }
        return result;
    }
    public static void main(String[] args) {
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[][] anagramGroups = groupAnagrams1(words);
        System.out.println(Arrays.deepToString(anagramGroups));
        // Output: [[ate, eat, tea], [bat], [nat, tan]]
    }

    public static String[][] groupAnagrams1(String[] words) { //намного лучше вариант
        Map<String, List<String>> groups = Arrays.stream(words)
                .collect(Collectors.groupingBy(
                        word -> Arrays.stream(word.split(""))
                                .sorted()
                                .collect(Collectors.joining()),
                        Collectors.mapping(Function.identity(), Collectors.toList())
                ));
        return groups.values().stream()
                .map(list -> list.stream()
                        .sorted()
                        .toArray(String[]::new))
//                .sorted(Comparator.comparing(arr -> arr[0])) // сортируем по первому элементу каждого вложенного массива
                .toArray(String[][]::new);
    }
    public static String[][] groupAnagrams2(String[] words) {
        Map<String, String[]> groups = Arrays.stream(words)
                .collect(Collectors.groupingBy(
                        word -> Arrays.stream(word.split(""))
                                .sorted()
                                .collect(Collectors.joining()),
                        Collectors.mapping(Function.identity(), Collectors.toList())
                ))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> {
                            String[] group = entry.getValue().toArray(new String[0]);
                            Arrays.sort(group); // сортировка вложенного массива
                            return group;
                        }
                ));
        return groups.values().toArray(new String[0][]);
    }
}
