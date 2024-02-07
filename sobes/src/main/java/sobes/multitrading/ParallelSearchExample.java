package sobes.multitrading;

import ru.job4j.sobes.javacor.algoritmi.BinarySearch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ParallelSearchExample {
    public static void main(String[] args) {
        List<Integer> numbers = createLargeCollection(); // Создание очень большой коллекции

        int chunkSize = 1000; // Размер каждого отрезка
        int searchValue = 42; // Значение, которое нужно найти

        List<CompletableFuture<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i += chunkSize) {
            List<Integer> chunk = numbers.subList(i, Math.min(i + chunkSize, numbers.size()));

            int c = i;
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                //int index = BinarySearch.binarySearchInList(chunk, searchValue);// 181  15878
                int index = chunk.indexOf(searchValue);// линейный поиск О(n) 226 15091
                if (index != -1) {
                    return c + index; // Возвращаем индекс найденного элемента в общей коллекции
                } else {
                    return -1; // Если элемент не найден в текущем отрезке
                }
            });

            futures.add(future);
        }

        CompletableFuture<Void> allFutures = CompletableFuture
                .allOf(futures.toArray(new CompletableFuture[0]));

        try {
            allFutures.get(); // Ожидаем окончания выполнения всех CompletableFuture
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Обработка результатов поиска
        for (CompletableFuture<Integer> future : futures) {
            try {
                int index = future.get();
                if (index != -1) {
                    System.out.println("Element found at index: " + index);
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    // Метод для создания очень большой коллекции
    private static List<Integer> createLargeCollection() {
        List<Integer> collection = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            collection.add(i);
        }
        return collection;
    }
}
