package ru.job4j.oop.nasledovanie;

public class Doctor extends Profession {
    private Pacient pacient;
    public Doctor(String name, String sur, String ed, String bir, Pacient pac) {
        super(name, sur, ed, bir);
        this.pacient = pac;
    }
    public Diagnose heal(Pacient pacient) {
        Diagnose diagnose = new Diagnose();
        return diagnose;
    }
}
