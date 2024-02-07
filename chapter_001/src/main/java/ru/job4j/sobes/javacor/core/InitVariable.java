package ru.job4j.sobes.javacor.core;

public class InitVariable {
    private static int y;
    private final int instanceNumber;
    private  int x;
    public InitVariable(int instanceNumber) {this.instanceNumber = instanceNumber;}
    public String toString() {return String.valueOf(instanceNumber);}

    private static void doIt(int i, InitVariable a) {
        i = 11;
        a.x = 12;//поменяли в объекте 1
        a.y = 13;//так же поменяли в 1 статическую
        a = new InitVariable(2);//2 создали 2й объект для *парметра метода, но первый остался
        a.x = 21;
        a.y = 22;//еще раз поменяли статическую
       // System.out.println(a);//2
    }

    public static void main(String[] args) {
        InitVariable a = new InitVariable(1);//1 ссылка здесь в переменной в методе не заменяется
        a.x = 1;//меняется в методе по ссылке
        a.y = 2;
        int z = 3;//int нельзя изменить в методе - копируется
        //a = new InitVariable(3);//но в этом же методе можно заменить ссылку переменной а
        InitVariable.doIt(z, a);//сюда тоже передаем копированную ссылку для парметра
        //параметру а метода присваиваем ссылку переменной а

        System.out.println(a);//1
        System.out.println(a.instanceNumber);//1
        System.out.println(a.x);//12
        System.out.println(a.y);//22
        System.out.println(z);//3
    }
}
