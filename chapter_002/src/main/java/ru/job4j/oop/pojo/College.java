package ru.job4j.oop.pojo;
import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Peta");
        student.setSurname("Ivanov");
        student.setGroup("Program");
        student.setBegin(new Date());
        System.out.println(student.getName() + " " + student.getSurname() + " from " + student.getGroup() + " begin in " + student.getBegin());
    }
}
