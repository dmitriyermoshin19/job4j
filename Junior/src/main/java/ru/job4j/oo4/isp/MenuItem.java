package ru.job4j.oo4.isp;

import java.util.List;

public class MenuItem {
    private final String name;
    private List<String> stringListSubMenu;

    public MenuItem(String name, List<String> stringList) {
        this.name = name;
        this.stringListSubMenu = stringList;
    }

    public MenuItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getStringListSubMenu() {
        return stringListSubMenu;
    }
}
