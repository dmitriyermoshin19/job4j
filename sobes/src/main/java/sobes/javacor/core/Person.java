package sobes.javacor.core;

@MyAnnotation(value = "")
public class Person extends A {
    private static int id;

    public static Person of() {
        as();
        Person p = new Person();
        id++;
        return p;
    }

    public int getPersonId() {
        a();
        return id;
    }

    public static void main(String[] args) {
        A a = new A();
        a.a();
        for (int i = 0; i < 10; i++) {
            System.out.println(Person.of().getPersonId());
        }
    }
}

class Person1 {
    private static int id;

    public Person1() {
        id++;
    }

    public int getPersonId() {
        return id;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new Person1().getPersonId());
        }
    }
}