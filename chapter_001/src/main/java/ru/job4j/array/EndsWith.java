package ru.job4j.array;

public class EndsWith {
    public static boolean endsWith(char[] word, char[] post) {
        boolean result = false;
        // проверить. что массив word имеет последние элементы одинаковые с post
        for (int index = 0; post.length >  index; index++) {
            if (word[(word.length - 1) - index] != post[(post.length - 1) - index]) {
                result =  false;
                break;
            } else {
                result = true;
            }
        }
        return result;
    }
}
