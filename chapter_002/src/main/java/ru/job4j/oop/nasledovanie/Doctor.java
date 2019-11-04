package ru.job4j.oop.nasledovanie;

public class Doctor extends Profession {
    private Pacient pacient;
    public Diagnose heal(Pacient pacient) {
        Diagnose diagnose = new Diagnose();
        return diagnose;
    }

}
