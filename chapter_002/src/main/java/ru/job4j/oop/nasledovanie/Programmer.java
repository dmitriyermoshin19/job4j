package ru.job4j.oop.nasledovanie;

public class Programmer extends Engineer {
    private String prog;
    public Programmer(String name, String sur, String ed, String bir, String cher) {
        super(name, sur, ed, bir, cher);
    }
    public String delaetProg(String prog) {
        return prog;
    }
}
