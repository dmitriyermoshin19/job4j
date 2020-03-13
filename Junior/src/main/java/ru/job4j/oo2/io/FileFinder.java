package ru.job4j.oo2.io;

import java.io.*;
import java.util.*;

public class FileFinder {

    /**
     * Проверка на соответствие файла условию
     * @param file - проверяемый файл
     * @param name - имя искомого файла, маска или регулярное выражение для поиска
     * @param mode - параметр поиска
     * @return - резуьтат сравнения
     */
    public boolean checkFile(File file, String name, String mode) {
        if (mode.equals("-f")) {
            return file.getName().equals(name);
        } else {
            return file.getName().matches(name);
        }
    }

    /**
     * Метод поиска файлов в заданой директории
     * @param sours - директория поиска
     * @param name - имя искомого файла, маска или регулярное выражение для поиска
     * @param mode - параметр поиска
     * @return - коллекция найденных файлов
     */
    public List<File> seekBy(String sours, String name, String mode) {
        List<File> list = new ArrayList<>();
        File folder = new File(sours);
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            if (file.isDirectory()) {
                list.addAll(seekBy(file.toString(), name, mode));
            } else if (checkFile(file, name, mode)) {
                list.add(file);
            }
        }
        return list;
    }

    /**
     * Запись результата в лог
     * @param source - найденные файлы
     * @param target - лог-файл
     */
    public void write(List<File> source, String target) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(target))) {
            for (File file : source) {
                out.write(file.getAbsolutePath());
                out.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        // -d C:\projects\job4j\Junior\src\main\java\ru\job4j\oo2\io -n Search.java -f -o C:\projects\job4j\Junior\src\main\java\ru\job4j\oo2\io\log.txt
        Args args1 = new Args(args);
        FileFinder fileFinder = new FileFinder();
        List<File> fileList = fileFinder.seekBy(args1.directory, args1.name, args1.mode);
        fileFinder.write(fileList, args1.output);
    }

    /**
     * Класс ключей
     */
    private static class Args {
        String msg = "Откорректируйте ключи:\n"
                + "-d директория поиска\n"
                + "-n имя фйла, маска или регулярное выражение\n"
                + "-f параметр поиска - по полному имени файла\n"
                + "-m параметр поиска - по маске\n"
                + "-r параметр поиска - по ругулярному выражению\n"
                + "-o файл с результатом поиска файлов";

        /**
         * Директория поиска
         */
        private String directory;
        /**
         * Имя файла, маска или регулярное выражение
         */
        private String name;
        /**
         * Параметр поиска
         */
        private String mode;
        /**
         * Лог-файл
         */
        private String output;

        public Args(String[] args) {
            int i = 0;
            while  (i < args.length) {
                switch (args[i]) {
                    case ("-f"):
                        mode = "-f";
                        break;
                    case ("-r"):
                        mode = "-r";
                        break;
                    case ("-m"):
                        mode = "-m";
                        break;
                    case ("-d"):
                        this.directory = args[++i];
                        break;
                    case "-n":
                        this.name = args[++i];
                        break;
                    case "-o":
                        this.output = args[++i];
                        break;
                    default:
                        throw new IllegalArgumentException(msg);
                }
                i++;
            }
            /**
             * Проверка заполненности ключей
             * @return - результат проверки
             */
            if (directory == null || name == null || mode == null || output == null) {
                throw new IllegalArgumentException(msg);
            }
        }
    }
}
