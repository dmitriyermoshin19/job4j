package ru.job4j.lambda;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public static class Student {
        private final int score;;

        public Student(int score) {
            this.score = score;
        }

        public int getScore() {
            return score;
        }

        @Override
        public String toString() {
            return "Student{" + "score='" + score + '\'' + '}';
        }
    }

    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }
}
