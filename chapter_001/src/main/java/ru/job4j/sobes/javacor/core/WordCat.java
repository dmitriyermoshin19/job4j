package ru.job4j.sobes.javacor.core;

public class WordCat {
    /**
     * Необходимо создать статический метод:
     * String killChars(String val, String chars)
     * На выходе возвращает строку val, у которой удалены все символы,
     * присутствующие в строке chars без учета регистра символов.
     * Проверочный пример:
     * При val="ABCdefabc" и chars="be"
     * на выходе должно быть "ACdfac"
     */
    public static String killChars(String val, String chars) {

        for (char c : chars.toCharArray()) {
            val = val.replace(String.valueOf(c), "");
            val = val.replace(String.valueOf(c).toUpperCase(), "");
        }
        return val;
    }

    public static void main(String[] args) {
        String val = "ABCdefac";
        String chars = "be";
        String r = WordCat.killChars(val, chars);
        System.out.println(r);
    }
}
