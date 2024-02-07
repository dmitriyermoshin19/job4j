package ru.job4j.oop.obiekti;

public class Jukebox {
    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        } else if (position == 2) {
            System.out.println("Спокойной ночи");
        } else {
            System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox a = new Jukebox();
        int b = 1;
        int c = 2;
        int d = 3;
        a.music(b);
        a.music(c);
        a.music(d);
    }
}
