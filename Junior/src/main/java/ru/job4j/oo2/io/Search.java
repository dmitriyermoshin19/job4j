package ru.job4j.oo2.io;

import java.io.File;
import java.util.*;
import java.util.function.Predicate;

import java.util.function.Predicate;

public class Search {

    /**
     * @param parent - это путь до каталога, с которого нужно осуществлять поиск.
     * @param predicate - это расширения файлов, которые мы хотим получить.
     * @return List<File> подходящих хайлов.
     */
    public List<File> files(String parent, Predicate<File> predicate) {
        List<File> list = new ArrayList<>();
        File file = new File(parent);
        for (File f : Objects.requireNonNull(file.listFiles())) {
            if (f.isDirectory()) {
                list.addAll(files(f.toString(), predicate));
            } else if (predicate.test(f)) {
                list.add(f);
            }
        }
        return list;
    }
}
