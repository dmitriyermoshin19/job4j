package ru.job4j.sobes.javacor.collections;

import java.util.HashMap;
import java.util.Map;

public class ExampleHashMap {
    static class SomeKey {
        public String value;
        SomeKey(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "SomeKey{" +
                    "value='" + value + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
            SomeKey someKey = (SomeKey) o;
//            return Objects.equals(value, someKey.value);
            if (o instanceof SomeKey) { //переоределен все *правильно только по другому
                return value.equals(someKey.value);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return 1;//скададываться будут все в одну корзину, но по икволс будут српвниваться правильно
        }
    }
    public static void main(String[] args) {
        Map<SomeKey, String> test = new HashMap<>();
        SomeKey key1 = new SomeKey("firstKey");
        SomeKey key2 = new SomeKey("secondKey");//скададываться будут все в одну корзину из за хешкода
        test.put(key1, "firstValue");
        test.put(key2, "secondValue");
        System.out.println(test.get(key1));// что здесь будет?

        SomeKey key3 = new SomeKey("secondKey");
        System.out.println(test.get(key3));// что будет здесь? ключ будет сравнивать по икволс

        key2.value = "";// меняем объект ключа, без проблем - найдет по икволс
        //но если правильно переопределить хешкод, то не найдет старую корзину по новому хешкоду
        System.out.println(test.get(key2));
        System.out.println(key2);
    }
}
