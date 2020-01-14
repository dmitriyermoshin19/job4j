package ru.job4j.lambda;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GroupTest {
    @Test
    public void whenSections() {
        var student1 = new Student("Kola", Set.of("1", "2"));
        var student2 = new Student("Lena", Set.of("1"));
        var student3 = new Student("Vadim", Set.of("1", "2", "3"));
        var result = Group.sections(List.of(student1, student3, student2));
        var expected = Map.of(
                "1", Set.of("Kola", "Lena", "Vadim"),
                "2", Set.of("Kola", "Vadim"),
                "3", Set.of("Vadim")
        );
        assertThat(result, is(expected));
    }
}
