package ru.job4j.oo2.io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс позволяет интерпретировать информацию, которую получает программа при запуске метода main
 * с настройками этого метода в Ran - edit в разделе Program arguments
 * В данном случае использована следующая строка:
 * -d C:\projects\job4j\Junior\ -e .*\.java -o project.zip
 */
public class Args {

    private String directory;
    private List<String> exclude = new ArrayList<>();
    private String output;

    /**
     * Конструктор разбивает переданные пользователем
     * параметры запуска(String[] args - массив аргументов) в командной строке
     * на части: -d - directory(что нужно архивировать),
     * -e - exclude(исключения,какие файлы не нужно архивировать),
     * -o - output(название файла на выходе, куда архивируем).
     */
    public Args(String[] args) {
        int i = 0;
        while (i < args.length) {
            switch (args[i]) {
                case ("-d"):
                    this.directory = args[++i];
                    break;
                case ("-e"):
                    this.exclude.add(args[++i]);
                    break;
                case ("-o"):
                    this.output = args[++i];
                    break;
                default:
            }
            i++;
        }
    }

    /**
     * Возвращает путь к директории которую нужно архивировать.
     * @return - путь.
     */
    public String getDirectory() {
        return this.directory;
    }

    /**
     * Возвращает расширение файлов которые не нужно архивировать.
     * @return - расширение файлов.
     */
    public List<String> getExclude() {
        return this.exclude;
    }

    /**
     * Возвращает название архива на выходе.
     * @return название архива.
     */
    public String getOutput() {
        return this.output;
    }
}
