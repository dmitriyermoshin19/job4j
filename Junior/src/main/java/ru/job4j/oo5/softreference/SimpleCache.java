package ru.job4j.oo5.softreference;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class SimpleCache {
    public static HashMap<String, SoftReference<String>> cache = new HashMap<>();

    public static String readFile(String key) {
        String str = "";
        try {
            str = Files.readString(Paths.get(
                    "C:/Projects/job4j/Junior/src/main/java/ru/job4j/oo5/softreference/" + key));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File is not found");
        }
        return str;
    }

    public static String cacheGet(String key) {
        String str = null;
        if (cache.containsKey(key)) {
            str = cache.get(key).get();
        }
        if (str == null) {
            str = readFile(key);
            SoftReference<String> value = new SoftReference<>(str);
            cache.put(key, value);
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(cacheGet("address.txt"));
        System.out.println(cacheGet("name.txt"));
    }
}
