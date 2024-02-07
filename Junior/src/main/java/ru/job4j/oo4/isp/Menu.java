package ru.job4j.oo4.isp;

import java.util.*;

public class Menu implements CreateMenu, ShowMenu, ExecuteAction {

    /**
     * Creating an ordered menu
     */
    @Override
    public Set<String> create(List<MenuItem> listMI) {
        Set<String> treeSetMenu = new TreeSet<>();
        for (MenuItem mi : listMI) {
            List<String> list = mi.getStringListSubMenu();
            String name = mi.getName();
            treeSetMenu.add(name);
            if (list != null) {
                for (String val : list) {
                    treeSetMenu.add(name.concat(val));
                }
            }
        }
        return treeSetMenu;
    }

    /**
     * Counts the number of points in the menu name
     */
    private Integer numberOfDots(String name) {
        int rsl = 0;
        for (Character val : name.toCharArray()) {
            if (val.equals('.')) {
                rsl++;
            }
        }
        return rsl;
    }

    /**
     * Outputs a line first and then a string from the menu
     * @param menu ordered menu
     */
    @Override
    public void show(Set<String> menu) {
        String line = "---";
        for (String str : menu) {
            int number = numberOfDots(str) - 1;
            for (int i = 0; i < number; i++) {
                System.out.print(line);
            }
            System.out.println(str);
        }
    }

    /**
     * Performs an action on the specified item
     * @param menuItem menu item
     */
    @Override
    public void execute(MenuItem menuItem) {
        //to do action
    }

    /**
     * Selecting a menu item to execute
     * @param name name of the menu item
     * @param listMI list of menu items
     */
    @Override
    public void select(String name, List<MenuItem> listMI) {
        Optional<MenuItem> menuItem =
                listMI.stream()
                        .filter(mi -> mi.getName().equals(name))
                        .findFirst();
        if (menuItem.isPresent()) {
            MenuItem rsl = menuItem.get();
            execute(rsl);
        }
    }

    public static void main(String[] args) {
        MenuItem mi1 = new MenuItem("Пункт 1.", Arrays.asList("1.", "2."));
        MenuItem mi2 = new MenuItem("Пункт 2.");
        MenuItem mi3 = new MenuItem("Пункт 3.", Arrays.asList("1.", "2."));
        MenuItem mi4 = new MenuItem("Пункт 3.1.", Arrays.asList("1.", "2."));
        MenuItem mi5 = new MenuItem("Пункт 4.", Arrays.asList("1.", "2."));
        List<MenuItem> listMI = List.of(mi1, mi2, mi3, mi4, mi5);
        Menu menu = new Menu();
        menu.show(menu.create(listMI));
    }
}
