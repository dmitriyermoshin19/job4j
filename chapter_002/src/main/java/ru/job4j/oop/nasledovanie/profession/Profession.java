package ru.job4j.oop.nasledovanie.profession;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private String birthday;

    public Profession(String name, String sur, String ed, String bir) {
        this.name = name;
        this.surname = sur;
        this.education = ed;
        this.birthday = bir;
    }

    public String getName(String name) {
        this.name = name;
        return name;
    }

    public String getSurname(String surname) {
        this.surname = surname;
        return surname;
    }

    public String getEducation(String education) {
        this.education = education;
        return education;
    }

    public String getBirthday(String birthday) {
        this.birthday = birthday;
        return birthday;
    }
}
