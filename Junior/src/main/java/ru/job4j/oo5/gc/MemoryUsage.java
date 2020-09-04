package ru.job4j.oo5.gc;

import static com.carrotsearch.sizeof.RamUsageEstimator.sizeOf;

public class MemoryUsage {

    private static class User {
        int id;

        public User(int id) {
            this.id = id;
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("finalize " + id);
        }

        @Override
        public String toString() {
            return "User{" + "id='" + id + '\'' + '}';
        }
    }

    public static void main(String[] args) {
        System.out.println("### START ###");
        info();

        // 2 Создать несколько объектов User и руками рассчитать сколько он будет занимать памяти.
/*
        memOf(new User("")); // 7 ячеек * 8 байт = 56 байт
        memOf(new User(" ")); //56 + " " 8 = 64 байта
        memOf(new User("88888888")); //56 + "88888888" 8 = 64 байта
        memOf(new User("888888881")); //64 + "1" 8 = 72 байта
        memOf(new User("8888888812345678")); //64 + "12345678" 8 = 72 байта
        memOf(new User("test1234123456789")); //72 + "9" 8 = 80 байт

        // 3 Нужно найти информацию. Сколько памяти занимает пустой объект без полей.

        memOf(new Object()); // 16 байт
        memOf(null); // 0 байт

        class Empty {
            // заголовок 12 + 4 остаток = 16 байт - пустой объект без полей
            final String name; // заголовок 12 + 4 поле = 16 байт
            //String id; //16 + 4 поле + 4 остаток = 24 байт
            public Empty(String name) {
                this.name = name;
            } //16 + конструктор 40 = 56 байт
            @Override
            protected void finalize() throws Throwable {
                super.finalize();
                System.out.println("finalize");
            } // 56 + 0 finalize() = 56 байт
            @Override
            public String toString() {
                return "User{" + "name='" + name + '\'' + '}';
            } // 56 + 0 toString() = 56 байт

        }
        memOf(new Empty("")); // 56 байт - объект new User("")

        //4 Добиться состояния, когда виртуальная машины вызывает сборщик мусора самостоятельно.
        // За счет ключей xmx.

        //вызов finalize искусственным путем через метод System.gc()
        for (int i = 0; i < 9; i++) {
            User user = new User(i);
            System.out.println(user);
        } //

        // еще один способ для вызова finalize через System.gc()
        User user = new User(11);
        System.out.println(user);
        user = null;
        //System.gc();
*/
        //вызов finalize через ограничение использования памяти до 4мб с VM option: -Xmx4m
        //для этого надо сделать 4625 объектов  new User(i) по 64 байта
        for (int i = 0; i < 4625; i++) {
            User user = new User(i);
            System.out.println(user);
        }

        System.out.println();
        System.out.println("### FINISH ###");
        info();
    }

    public static void memOf(Object object) {
        if (object != null) {
            System.out.println("Mem of: " + object.toString() + " is: " + sizeOf(object) + " bytes");
        } else {
            System.out.println("Mem of: null = 0 bytes");
        }
    }

    public static void info() {
        int mb = 1024 * 1024;

        // Getting the runtime reference from system
        Runtime runtime = Runtime.getRuntime();

        System.out.println("##### Heap utilization statistics [MB] #####");

        // Print used memory
        System.out.println("Used memory: "
                + (runtime.totalMemory() - runtime.freeMemory()) / mb);

        // Print free memory
        System.out.println("Free memory: " + runtime.freeMemory() / mb);

        // Print total available memory
        System.out.println("Total available memory: " + runtime.totalMemory() / mb);

        // Print Maximum available memory
        System.out.println("Max memory: " + runtime.maxMemory() / mb);

        // Print new line
        System.out.println();
    }
}
