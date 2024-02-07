package ru.job4j.sobes.javacor.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pecs {
    class A {}
    class B extends A {}

    public  void main(String[] args) {
        B b = new B();
        List<? extends A> list = List.of(new B(), new A());//только так можно добавить в коллекцию
        //list.add(b); // добавить нельзя - подчеркивает
        for (A l : list) {

        }
        List<? super B> list1 = new ArrayList<>();
        list1.add(b);
        //for (B l : list1) {} // нельзя читать - подчеркивает

        A a = new A();
        List<A> list2 = new ArrayList<>();
        list2.add(b);
        list2.add(a);//можно положить наследников - принцип Барбары Лисков

        List<B> list3 = new ArrayList<>();
        list3.add(b);
        //list3.add(a); //родителей нельзя положить - подчеркивает
    }
}
