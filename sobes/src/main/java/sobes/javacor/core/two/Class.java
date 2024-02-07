package ru.job4j.sobes.javacor.core.two;

public class Class extends Class1 {
    String name = "Class";// без final можно перезаписать
    String name1 = cl; // если поставить в родителе прайвет, то тут не увидит

     static class Parent extends Class {
         private static final  String name = "Parent"; //переопределена
         String superName = super.name = "";// перезаписываем переменную родителя
         String getName = super.name;// здесь она уже другая - старую не возвратить

        public Parent() {
            System.out.println("конструктор родителя:");
            System.out.println(superName + getName);
            print1();
            print();
        } //конструктор всегда запускается

        void print1() {
            System.out.println("метод родителя print1()");
            System.out.println("Parent-" + name);//не переопределенный не изменяет
        }

        void print() {
            System.out.println("метод родителя");
            System.out.println("Parent");//при переопределении в чалде изменяет и там и здесь!
        }
    }

      static class Child extends Parent {
        String name = "Child + " + super.name + super.name1 + cl + " - не статическая"; // переопределена, своя для каждого объекта
        static String name1 = "Child + " + Parent.name + " - статическая"; // переопределена, статическая - одна для всех

        Child(String name) {this.name1 = name;};
        Child() {
//            super.name = "Child"; нельзя перезаписать final
            System.out.println("конструктор потомка ");
            print();
            super.print();
            print1();
        }
//        void print1() {
//            System.out.println("метод потомка print1()");
//            System.out.println("print1-" + name);//не переопределенный не изменяет
//        }

        void print() {  //переопределение
            System.out.println("метод потомка");
            System.out.println(name + "-Child-" + super.name);
        }
    }

    class New {
        String p = new Parent().name;

    }
    public static void main(String[] args) {
        Child child = new Child();//выходит два раза Child- из родителя переопр.метод и из чалд метод
//        Parent parent = new Parent();//выходит два раза Child- из родителя переопр.метод и из чалд метод
    }
}