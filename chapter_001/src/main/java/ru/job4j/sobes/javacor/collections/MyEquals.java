package ru.job4j.sobes.javacor.collections;

import lombok.AllArgsConstructor;

import java.util.Objects;

public class MyEquals {

    public static void main(String[] args) {
        MyClass myClass = new MyClass("name");
        MyClass myClass1 = new MyClass("name");//по умолчанию всегда разные ссылки
        boolean b = myClass.equals(myClass1);//ответ: одинаковые, если переопр.икволс и хешкод
        System.out.println(b);
        boolean b1 = myClass1 == myClass;//тоже сравниваются ссылки - ответ: всегда разные
        System.out.println(b1);

        YourClass yourClass = new YourClass();
        Class<? extends YourClass> clas = yourClass.getClass();
        boolean b2 = myClass.equals(yourClass);//у разных типов - разные ссылки Class классов, у одинаковых типов - одинаковые
        System.out.println(b2);
    }
}
//@Data //переопр.equals и хешкод
@AllArgsConstructor
class MyClass {
    String name;

    @Override
    public boolean equals(Object o) { //чтобы можно было проверить разные типы классов
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;//разные типы здесь обнаружатся
        MyClass myClass = (MyClass) o;
        return Objects.equals(name, myClass.name);//тут проверяем поля только у одинаковых типов
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
class YourClass {}