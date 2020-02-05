package ru.job4j.oo1.map;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "(" + this.name + this.children + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    public static void main(String[] args) {
        User user1 = new User("Ivan", 1, new GregorianCalendar(2000, Calendar.JANUARY, 1));
        User user2 = new User("Ivan", 1, new GregorianCalendar(2000, Calendar.JANUARY, 1));
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        Map<User, Object> map = new HashMap<>();
        map.put(user1, "first");
        map.put(user2, "second");
        System.out.println(map);
    }
}

