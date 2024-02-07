package ru.job4j.oop.nasledovanie.profession;

public class Builder extends Engineer {
    private String dom;

    public Builder(String name, String sur, String ed, String bir, String cher, String d) {
        super(name, sur, ed, bir, cher);
        this.dom = d;
    }

    public String stroitDom(String dom) {
        return dom;
    }
}
