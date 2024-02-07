package ru.job4j.sobes.javacor.core;


interface MayInt1 {
    default void defaultMet() {
        System.out.println("z;lj");
    }
    default void defaultMet1() {
        System.out.println("z;lj");
    }
}

interface MayInt {
    default void defaultMet() { //при двух одинаковых методах потребует переопределить
        System.out.println("z;lj");
    }
}

public class ToInterfaces implements MayInt, MayInt1 {
    public void someMetod() {
        defaultMet1();
        MayInt.super.defaultMet();
        MayInt1.super.defaultMet();
    }

    @Override
    public void defaultMet() {

    }

    public static void main(String[] args) {
        new ToInterfaces().defaultMet();
    }
}
