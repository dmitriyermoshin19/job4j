package ru.job4j.sobes.javacor.seva.set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MySet {
    String name;
    String lastname;

    public MySet(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MySet mySet = (MySet) o;
        return Objects.equals(name, mySet.name) && Objects.equals(lastname, mySet.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastname);
    }

    @Override
    public String toString() {
        return "MySet{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Set<MySet> set = new HashSet<>();
        MySet set1 = new MySet("Dima", "Ermoshin");
        set.add(set1);
        set1.setName("Seva");
        set1.setLatname("Kazakov");

        System.out.println(set);

        MySet set2 = new MySet("Seva", "Kazakov");
        set.add(set2);
        System.out.println(set);

        MySet set3 = new MySet("Dima", "Ermoshin");
        //set.add(set3);
        System.out.println(set);
        System.out.println(set.contains(set3));

        //MySet set3 = new MySet("Seva", "Kazakov");
        //set.add(set3);
        //System.out.println(set);
    }
}
