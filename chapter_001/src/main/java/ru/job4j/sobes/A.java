package ru.job4j.sobes;

public class A {
    static int x = 0;
    int y = 1;
    {
        System.out.println("A");
    }
    static {
        System.out.println("A static block");
    }

    public void a() {
        System.out.println("метод a()");
    }

    public static void as() {
        System.out.println("!!! as() static");
    }

    public A() {
        System.out.println("A constructor");
    }

    static class B extends A {
        static int u = 8;

        static class C extends B {

            public C() {
                System.out.println("C constructor");
            }

            {
                System.out.println("C");
            }

            static {
                System.out.println("C static block");
            }

            public static void main(String[] args) {
                A.B.C b = new C();
                b.a();
                as();
            }
        }
        {
            System.out.println("B");
        }
        static {
            System.out.println("B static block");
        }

        public B() {
            System.out.println("B constructor");
        }
    }

    public static void main(String[] args) {
      B b = new B();
    }
}


