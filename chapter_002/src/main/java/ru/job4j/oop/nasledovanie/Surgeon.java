package ru.job4j.oop.nasledovanie;

public class Surgeon extends Doctor {
    private String geludok;
    public Surgeon(String name, String sur, String ed, String bir, Pacient pac, String gel) {
        super(name, sur, ed, bir, pac);
        this.geludok = gel;
    }
    public String rezetGeludok(String geludok) {
        return geludok;
    }
}
