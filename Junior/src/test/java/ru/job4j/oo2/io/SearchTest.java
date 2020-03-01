package ru.job4j.oo2.io;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class SearchTest {

    @Test
    public void myFolderTesting() {
        String path = "./src/main";
        Search search = new Search();
        List<File> rsl = search.files(path, f -> {
            List<String> ext = List.of("txt", "java", "properties", "csv");
            return ext.contains(f.getName().substring(f.getName().indexOf(".") + 1));
        });
        assertThat(rsl.contains(new File("./src/main/java/ru/job4j/oo1/map/Analize.java")), is(true));
        assertThat(rsl.contains(new File("./src/main/java/ru/job4j/oo1/map/SimpleHashMap.java")), is(true));
        assertThat(rsl.contains(new File("./src/main/java/ru/job4j/oo1/map/app.prop")), is(false));
        //assertThat(rsl.size(), is(29));
        rsl.forEach(System.out::println);
    }
}
