package ru.job4j.sobes.patterns;

public class Good {
    //большое количество однотипных параметров и трудно запомнить их порядок и назначение
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;

    private Good(Builder builder) { //принимает Builder и у конструктора модификатор private
        a = builder.a;
        b = builder.b;
        c = builder.c;
        d = builder.d;
        e = builder.e;
        f = builder.f;
    }

    //Реализация Builder через статический внутренний класс
    private static class Builder {
        //Обязательные параметры
        private final int a;
        private final int b;
        //Необязательные параметры со значениями по умолчанию
        private int c = 0;
        private int d = 0;
        private int e = 0;
        private int f = 0;

        //Конструктор с обязательными параметрами
        public Builder(int a, int b) {
            this.a = a;
            this.b = b;
        }

        //Методы с возвращающим типом Builder для необязательного параметра с, d, e, f,
        public Builder c(int val) { //одновремнно инициализируем и возвращаем Builder
            c = val;
            return this;
        }

        public Builder d(int val) {
            d = val;
            return this;
        }

        public Builder e(int val) {
            e = val;
            return this;
        }

        public Builder f(int val) {
            f = val;
            return this;
        }

        //Метод с возвращающим типом Good для генерации объекта
        public Good buidl() {
            return new Good(this);
        }
    }

    public static void main(String[] args) {
//        new myjar.jar.ru.job4j.sobes.patterns.Good.Builder(1,2).c(3).d(4).e(5).f(6).buidl();
        Good good = new Good.Builder(1,2).c(3).d(4).e(5).f(6).buidl();
        System.out.println("a:"+good.a+" b:"+ good.b+ " c:"+good.c);
    }
}
