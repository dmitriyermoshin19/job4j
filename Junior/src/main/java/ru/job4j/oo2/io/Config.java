package ru.job4j.oo2.io;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    /**
     * Метод для сохранения кофигурационного файла вида
     * hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
     * в коллекцию HashMap
     */
    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines()
                    .filter(line -> line.matches(".+[=].+"))
                    .forEach(line -> values.put(
                            line.substring(0, line.indexOf("=")),
                            line.substring(line.indexOf("=") + 1))
                    );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }
/*
    public static void main(String[] args) {
        System.out.println(new Config("Junior\\src\\main\\resources\\app.properties"));
        Config c = new Config("Junior\\src\\main\\resources\\app.properties");
        c.load();
        System.out.println(c.values);
    }*/
}
