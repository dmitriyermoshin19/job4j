package ru.job4j.oo2.io;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.util.function.Predicate;

/**
 * Класс позволяет получить архив файлов с сохранением структуры папок.
 */
public class Zip {
    /**
     * Метод осуществляет поиск нужных нам файлов, которые потом будем архивировать,
     * используя метод files класса Search с переопределением Predicate для исключаемых файлов
     *
     * @param root путь с которого необходимо начать поиск файлов
     * @param ext  файлы которые необходимо исключить
     * @return Список файлов
     */
    public static List<File> seekBy(String root, List<String> ext) {
        Predicate<File> predicate = f -> !ext.contains(f.getName().substring(f.getName().indexOf(".") + 1));
        return new Search().files(root, predicate);
    }

    /**
     * Метод позволяет получить архив в формате Zip
     *
     * @param sources Список исходных файлов для архивации
     * @param target  Файл после упаковки в формате zip
     */
    public static void pack(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File f : sources) {
                zip.putNextEntry(new ZipEntry(f.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(f))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * в настройках Run-Edit-Program arguments записываем строку для запуска программы:
     * -d C:\projects\job4j\Junior\ -e xml -e iml -o project1.zip
     *
     * @param args массив аргументов: -d C:\projects\job4j\Junior\ -e xml -o project.zip
     */
    public static void main(String[] args) {
        Args oArgs = new Args(args);
        Zip.pack(Zip.seekBy(oArgs.getDirectory(),
                oArgs.getExclude()), new File(oArgs.getOutput()));
    }
}
