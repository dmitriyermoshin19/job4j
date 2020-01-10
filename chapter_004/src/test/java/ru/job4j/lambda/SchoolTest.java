package ru.job4j.lambda;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    @Test
    public void whenClassA() {
        School school = new School();
        School.Student student1 = new School.Student(5);
        School.Student student2 = new School.Student(50);
        School.Student student3 = new School.Student(60);
        School.Student student4 = new School.Student(70);
        School.Student student5 = new School.Student(80);
        School.Student student6 = new School.Student(90);
        List<School.Student> students = List.of(
                student1, student2, student3, student4, student5, student6
        );
        List<School.Student> expected = List.of(student5, student6);
        List<School.Student> result = school.collect(
                students,
                student -> student.getScore() > 70 && student.getScore() < 100
        );
        assertThat(result, is(expected));
    }

    @Test
    public void whenClassB() {
        School school = new School();
        School.Student student1 = new School.Student(5);
        School.Student student2 = new School.Student(50);
        School.Student student3 = new School.Student(60);
        School.Student student4 = new School.Student(65);
        School.Student student5 = new School.Student(80);
        School.Student student6 = new School.Student(90);
        List<School.Student> students = List.of(
                student1, student2, student3, student4, student5, student6
        );
        List<School.Student> expected = List.of(student3, student4);
        List<School.Student> result = school.collect(
                students,
                student -> student.getScore() > 50 && student.getScore() < 70
        );
        assertThat(result, is(expected));
    }

    @Test
    public void whenClassC() {
        School school = new School();
        School.Student student1 = new School.Student(5);
        School.Student student2 = new School.Student(40);
        School.Student student3 = new School.Student(60);
        School.Student student4 = new School.Student(65);
        School.Student student5 = new School.Student(80);
        School.Student student6 = new School.Student(90);
        List<School.Student> students = List.of(
                student1, student2, student3, student4, student5, student6
        );
        List<School.Student> expected = List.of(student1, student2);
        List<School.Student> result = school.collect(
                students,
                student -> student.getScore() > 0 && student.getScore() < 50
        );
        assertThat(result, is(expected));
    }

    @Test
    public void whenToMap() {
        School school = new School();
        School.Student student1 = new School.Student("Ivan");
        School.Student student2 = new School.Student("Petr");
        List<School.Student> students = List.of(student1, student2);
        Map<String, School.Student> result = school.listToMap(students);
        Map<String, School.Student> expected = new HashMap<>();
        expected.put("Ivan", student1);
        expected.put("Petr", student2);
        assertThat(result, is(expected));
    }
}
