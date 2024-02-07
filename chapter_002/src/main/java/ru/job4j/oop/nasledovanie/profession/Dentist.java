package ru.job4j.oop.nasledovanie.profession;

public class Dentist extends Doctor {
    private String zub;

    public Dentist(String name, String sur, String ed, String bir, Pacient pac, String z) {
        super(name, sur, ed, bir, pac);
        this.zub = z;
    }

    public String lechitZubi(String zub) {
        return zub;
    }
}
