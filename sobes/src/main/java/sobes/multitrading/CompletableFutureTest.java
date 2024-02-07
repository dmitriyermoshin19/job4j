package sobes.multitrading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * реализация обработки коллекции с очень большим количеством элементов
 * использование parallelStream() в фоновом потоке runAsync()
 */
public class CompletableFutureTest {
    public static void main(String... args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<CompletableFuture<Double>> dividedResults = numbers.parallelStream()
                .map(number -> CompletableFuture.supplyAsync(() -> {
                    // Выполняйте здесь требуемую операцию над каждым элементом коллекции
                    return number / 2.0;
                }))
                .collect(Collectors.toList());

        // Дождитесь завершения всех CompletableFuture и получите результаты
        List<Double> results = dividedResults.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        // Выводим результаты
        results.forEach(System.out::println);



        List<CompletableFuture<Double>> futures = numbers.stream()
                .map(number -> CompletableFuture.supplyAsync(() -> {
                    // Выполняйте здесь требуемую операцию над каждым элементом коллекции
                    return number / 2.0;
                }))
                .collect(Collectors.toList());

        // Дождитесь завершения всех CompletableFuture и получите результаты
        List<Double> results1 = futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        // Выводим результаты
        results1.forEach(System.out::println);

//без использования stream api
        List<CompletableFuture<Double>> futures1 = new ArrayList<>();

        for (Integer number : numbers) {
            CompletableFuture<Double> future = CompletableFuture.supplyAsync(() -> {
                // Выполняйте здесь требуемую операцию над каждым элементом коллекции
                return number / 2.0;
            });
            futures1.add(future);
        }

        // Дождитесь завершения всех CompletableFuture и получите результаты
        List<Double> results2 = futures1.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        // Выводим результаты
        results2.forEach(System.out::println);



//с разделением всей коллекции на маленькие кусочки
        int chunkSize = 3; // Размер каждого кусочка коллекции

        List<CompletableFuture<List<Double>>> futures2 = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i += chunkSize) {
            List<Integer> chunk = numbers.subList(i, Math.min(i + chunkSize, numbers.size()));

            CompletableFuture<List<Double>> future = CompletableFuture.supplyAsync(() -> {
                return chunk.stream()
                        .map(number -> number / 2.0) // Вычисляем новое значение каждого элемента
                        .collect(Collectors.toList()); // Сохраняем результаты в новой коллекции
            });

            futures2.add(future);
        }

        // Дождитесь завершения всех CompletableFuture и получите результаты
        List<Double> results3 = futures2.stream()
                .flatMap(future -> future.join().stream())
                .collect(Collectors.toList());

        // Выводим результаты
        results3.forEach(System.out::println);

    }
}
