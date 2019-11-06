package ru.job4j.oop.nasledovanie;

public class Engineer extends Profession {
    private String cherteg;
    public Engineer(String name, String sur, String ed, String bir, String cher) {
        super(name, sur, ed, bir);
        this.cherteg = cher;
    }

    public Cherteg delaet(Zakaz zakaz) {
        Cherteg cherteg = new Cherteg();
        return cherteg;
    }
}
