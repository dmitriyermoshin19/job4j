package ru.job4j.sobes.javacor.collections;

import java.util.ArrayList;
import java.util.List;

public class Generics {
    static class Animal {
        public void makeSound() {
            System.out.println("Animal sound");
        }
    }

    static class Dog extends Animal {
        public void makeSound() {
            System.out.println("Woof!");
        }
    }

    static class Cat extends Animal {
        public void makeSound() {
            System.out.println("Meow!");
        }
    }

    public static void main(String[] args) {
        // Создаем список экземпляров класса Animal
//        List animals = new ArrayList<>();
        List<Animal> animals = new ArrayList<>();

        // Добавляем экземпляры классов Dog и Cat в список
        animals.add(new Dog());
        animals.add(new Cat());
//        animals.add("String");

        // Извлекаем элементы в виде экземпляров класса Dog
        Dog firstDog = (Dog) animals.get(0); // Ошибка может возникнет здесь, если неправильно скастить
        Cat firstCat = (Cat) animals.get(1); //так делали до jdk 5 без джинериков
//        String str = (String) animals.get(2);

        // Вызываем метод makeSound() для первого элемента списка
        firstDog.makeSound();
        firstCat.makeSound();
//        System.out.println(str);
    }
}
