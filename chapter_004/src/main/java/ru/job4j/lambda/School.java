package ru.job4j.lambda;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public static class Student {
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
    }

    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    Map<String, Student> listToMap(List<Student> students) {
        return students.stream().collect(Collectors.toMap(o -> o.getName(), o -> o));
    }
}
