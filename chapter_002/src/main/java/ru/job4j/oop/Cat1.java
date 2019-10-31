package ru.job4j.oop;

public class Cat1 {
    private String food;
    private String name;

    public void show() {
        System.out.println(this.name + " eat - " + this.food);
    }
    public void eat(String meat) {
        this.food = meat;
    }
    public void giveNick(String nick) {
        this.name = nick;
    }
    public static void main(String[] args) {
        System.out.println("There are gav's food.");
        Cat1 gav = new Cat1();
        gav.giveNick("Gaf");
        gav.eat("kotleta");
        gav.show();
        System.out.println("There are black's food.");
        Cat1 black = new Cat1();
        black.giveNick("Black");
        black.eat("fish");
        black.show();
    }
}
