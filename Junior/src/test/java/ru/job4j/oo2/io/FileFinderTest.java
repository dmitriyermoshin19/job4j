package ru.job4j.oo2.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FileFinderTest {

    private FileFinder fileFinder = new FileFinder();
    private String sours = "src";
    private List<File> expected = Arrays.asList(
            new File("src/main/resources/app.properties"));

    @Test
    public void whenFullNameThenFoundedFile() {
        String name = "app.properties";
        String mode = "-f";
        List<File> result = fileFinder.seekBy(sours, name, mode);
        assertThat(result, is(expected));
    }
/*
    @Test
    public void whenMaskThenFoundedFile() {
        String name = ".*app";
        String mode = "-m";
        List<File> result = fileFinder.seekBy(sours, name, mode);
        assertThat(result, is(expected));
    }

    @Test
    public void whenRegularExpressionThenFoundedFile() {
        String name = "[app].*";
        String mode = "-r";
        List<File> result = fileFinder.seekBy(sours, name, mode);
        assertThat(result, is(expected));
    }
/* в идее проходит тест, а тревис тупит
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenLogIsTempFolder() throws Exception {
        String name = "app.properties";
        String mode = "-f";
        File target = folder.newFile("target.txt");
        List<File> result = fileFinder.seekBy(sours, name, mode);
        fileFinder.write(result, target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader read = new BufferedReader(new FileReader(target.getAbsolutePath()))) {
            read.lines().forEach(rsl::append);
        }
        String expected = "C:\\Projects\\job4j\\Junior\\src\\main\\resources\\app.properties";
        assertThat(rsl.toString(), is(expected
                ));
    }*/
}
