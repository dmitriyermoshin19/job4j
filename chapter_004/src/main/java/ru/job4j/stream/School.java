package ru.job4j.stream;

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

    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    public Map<String, Student> listToMap(List<Student> students) {
        return students.stream().collect(Collectors.toMap(o -> o.getName(), o -> o));
    }

    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted(Student::compareTo)
                .takeWhile(s -> s.getScore() > bound)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Stream<String> s = Stream.of("1", null, "2");
        var s1 = s.peek(System.out::println).flatMap(Stream::ofNullable).collect(Collectors.toList());
        s1.forEach(System.out::println);

        Stream<String> st = Stream.of("1", null, "2");
        st.forEach(System.out::println);
        List<String> st1 = Stream.of("1", null, "2").flatMap(Stream::ofNullable).collect(Collectors.toList());
        st1.forEach(System.out::println);

        Stream<String> str = Stream.of("1", null, "2");
        str.forEach(System.out::println);
        //еще раз стрим использовать нельзя, он уже отработал один раз
        var l = str.flatMap(Stream::ofNullable).collect(Collectors.toList());
        l.forEach(System.out::println);
    }
}
