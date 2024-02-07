package ru.job4j.oop.nasledovanie.profession;

import ru.job4j.oop.nasledovanie.profession.Engineer;

public class Programmer extends Engineer {
    private String prog;

    public Programmer(String name, String sur, String ed, String bir, String cher) {
        super(name, sur, ed, bir, cher);
    }

    public String delaetProg(String prog) {
        return prog;
    }
}
