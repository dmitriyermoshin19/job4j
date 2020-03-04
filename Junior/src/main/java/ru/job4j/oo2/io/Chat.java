package ru.job4j.oo2.io;

import java.io.*;
import java.util.*;

public class Chat {
    private String input;
    private String output;

    /**
     * Constructor.
     *
     * @param input - путь к файлу с ответами бота.
     * @param output - путь к файлу с записью разговора.
     */
    public Chat(String input, String output) {
        this.input = input;
        this.output = output;
    }

    /**
     * метод передает информацию из текстового файла с отвтетами в коллекцию строк.
     *
     * @param input - файл для чтения.
     * @return коллекция строк.
     */
    public List<String> readBotAnswers(String input) {
        List<String> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(input))) {
            br.lines().forEach(result::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * метод возвращает случайные ответы бота из коллекции строк
     * и выводит их на консоль
     *
     * @param input - коллекция ответов.
     * @return случайная строка из коллекции.
     */
    private String getRandomBotAnswer(List<String> input) {
        Random random = new Random();
        String result = input.get(random.nextInt(input.size()));
        System.out.printf("%s: %s%n", "BOT", result);
        return result;
    }

    /**
     * метод осуществляет процесс разговори с ботом.
     * и записывает разговор в коллекцию
     */
    public void run() {
        List<String> botAnswers = this.readBotAnswers(this.input);
        List<String> log = new LinkedList<>();
        boolean mute = false;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String message = br.readLine();
            while (!"все".equals(message)) {
                if ("стоп".equals(message)) {
                    mute = true;
                }
                if ("дальше".equals(message)) {
                    mute = false;
                }
                log.add(String.format("%-10s%-20s", "*User:", message));
                if (!mute) {
                    log.add(String.format("%-10s%-20s%n", "*Bot:", this.getRandomBotAnswer(botAnswers)));
                }
                message = br.readLine();
            }
            log.add(String.format("%-10s%-20s%n", "*User:", message));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.writeLog(this.output, log);
    }

    /**
     * метод записывает коллекцию разговора в текстовый файл.
     * @param target - путь к текстовому файлу.
     * @param log - коллекция с разговором.
     */
    private void writeLog(String target, List<String> log) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(target))) {
            for (String line : log) {
                bw.write(line + '\n');
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out, true);
        pw.println("Введите какие-нибудь слова");
        pw.println("стоп - программа замолчит");
        pw.println("дальше - программа продолжит");
        pw.println("все - программа закончит работу.");
        Chat bot = new Chat(
                ClassLoader.getSystemResource("botAnswers.txt").getPath(),
                "Junior/src/main/java/ru/job4j/oo2/io/chatLog.txt"
        );
        bot.run();
    }
}
