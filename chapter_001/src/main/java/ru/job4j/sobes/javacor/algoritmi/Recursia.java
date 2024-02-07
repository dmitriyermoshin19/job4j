package ru.job4j.sobes.javacor.algoritmi;

public class Recursia {
    static class A {
        private B b;

        public A(B b) {
            this.b = b;
        }

        public void setB(B b) {
            this.b = b;
//            if (this.b != b) {
//                this.b = b;
//                b.setA(this);
//            }
//            if (this.b != null) {
//                this.b = b;
//                b.setA(this);
//            }
        }
    }
    static class B {
        private A a;

        public B(A a) {
            this.a = a;
        }

        public void setA(A a) {
            this.a = a;
            this.a.setB(new B(this.a));
//            if (this.a != a) {
//                this.a = a;
//                a.setB(this);
//            }
//            if (this.a != null) {
//                this.a = a;
//                a.setB(this);
//            }
        }
    }

    public static void main(String[] args) {
        A objA = new A(new B(null));
        B objB = new B(new A(null));

        objA.setB(objB);
        objB.setA(objA);
        System.out.println(objA);
    }
}



