package ru.job4j.oo2.io;
import java.io.*;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(
                        "Junior/src/main/java/ru/job4j/oo2/io/even.txt"))) {
            String number;
            while ((number = reader.readLine()) != null) {
                int num = Integer.parseInt(number);
                if ((num % 2) == 0) {
                    System.out.println(num + "- even number");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
