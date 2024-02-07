package ru.job4j.oo1multithreading.puli;

import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;
import java.util.concurrent.ForkJoinPool;

public class FindIndex<T> {

    public int sequenceFind(T[] array, T value) {
        return IntStream.range(0, array.length)
                .filter(i -> array[i].equals(value))
                .findFirst()
                .orElse(-1);
    }

    public int parallelFind(T[] array, T value) {
        if (array.length < 10) {
            return sequenceFind(array, value);
        }
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        return forkJoinPool.invoke(new ParallelTask<>(array, value));
    }

    private static class ParallelTask<T> extends RecursiveTask<Integer> {
        private final T[] array;
        private final T value;
        private final int from;
        private final int to;

        public ParallelTask(T[] array, T value) {
            this(array, value, 0, array.length - 1);
        }

        public ParallelTask(T[] array, T value, int from, int to) {
            this.array = array;
            this.value = value;
            this.from = from;
            this.to = to;
        }

        @Override
        protected Integer compute() {
            if (from == to) {
                if (array[from].equals(value)) {
                    return from;
                }
                return -1;
            }
            int mid = (from + to) / 2;
            ParallelTask<T> leftFind = new ParallelTask<>(array, value, from, mid);
            ParallelTask<T> rightFind = new ParallelTask<>(array, value, mid + 1, to);
            leftFind.fork();
            rightFind.fork();
            return Math.max(leftFind.join(), rightFind.join());
        }
    }
}
