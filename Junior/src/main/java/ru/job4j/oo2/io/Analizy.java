package ru.job4j.oo2.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Analizy {
    private boolean worked = true;

    public List<String> read(String source) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            lines = read.lines().filter(line -> line.matches("[0-9].+"))
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return lines;
    }

    void print(String source, String target) throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            List<String> lines = this.read(source);
            for (String l : lines) {
                List<String> pair = Arrays.asList(l.split(" "));
                int code = Integer.parseInt(pair.get(0));
                if (worked && code == 400 || code == 500) {
                    out.print(pair.get(1) + ";");
                    worked = false;
                }
                if (!worked && code == 200 || code == 300) {
                    out.println(pair.get(1) + " ");
                    worked = true;
                }
            }
        }
    }
}
