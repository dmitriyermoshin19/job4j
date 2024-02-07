package ru.job4j.oop.obiekti;

public class DummyDic {
    public String engToRus(String eng) {
        String slovo = "Неизвестное слово - " + eng;
        return slovo;
    }

    public static void main(String[] args) {
        DummyDic dic = new DummyDic();
        String say = "bark";
        String perevod = dic.engToRus(say);
        System.out.println("Dic says: " + perevod);
    }

}
