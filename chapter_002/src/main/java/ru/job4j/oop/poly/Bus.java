package ru.job4j.oop.poly;

public class Bus implements Transport {
    private int pasajiri;

    @Override
    public void ehat() {
        System.out.println("поехали");
    }

    @Override
    public void passajiri(int passajiri) {
        this.pasajiri = passajiri;
    }

    @Override
    public double zapravit(int litri) {
        double cena = litri * 50;
        return cena;
    }
}
