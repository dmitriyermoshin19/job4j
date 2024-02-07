package ru.job4j.sobes.javacor.core.two;

public class Class1 {
    String cl = "Class1";
//    String p1 =  new Class().name; StackOverflowError с этими полями
//    String p = new Class.Child().name;
    static String p3 =   Class.Child.name1;

    public static void main(String[] args) {
//        Class1[] m = new Class1[100000000*100000000]; // OutOfMemoryError - 100млн * 100млн

//        System.out.println(new Class1().p3);
        Class.Child p2 =  new Class.Child("перезаписал - 2");
        Class.Child p4 =  new Class.Child("перезаписал для второго объекта - 3");
         String p3 =  new Class.Child().name;
        System.out.println(p3 + " - первая");
        System.out.println(p2.name + " -  вторая");
        System.out.println(p4.name + " -  третья");
// хоотел сделать вывод статической и не статич. переменной, но не доделал
        String p5 =  new Class.Child().name1;
        System.out.println(p3 + " - первая");
        System.out.println(p2.name1 + " -  вторая");
        System.out.println(p4.name1 + " -  третья");
    }
}
