package ru.job4j.oo4.isp;

import java.util.List;

public interface ExecuteAction {
    void execute(MenuItem menuItem);
    void select(String name, List<MenuItem> listMI);
}
