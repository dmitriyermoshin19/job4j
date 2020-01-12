package ru.job4j.lambda;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class School {
    public static class Student implements Comparable<Student> {
        private int score;
        private String name;

        public Student(int score) {
            this.score = score;
        }

        public Student(String name) {
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Student{" + "score='" + score + '\'' + '}';
        }

        @Override
        public int compareTo(Student another) {
            return Integer.compare(another.score, score);
        }
    }

    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    Map<String, Student> listToMap(List<Student> students) {
        return students.stream().collect(Collectors.toMap(o -> o.getName(), o -> o));
    }

    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted(Student::compareTo)
                .takeWhile(s -> s.getScore() > bound)
                .collect(Collectors.toList());
    }
}
