package ru.job4j.oo4.tdd;

import java.util.Map;

public interface Generator {
    String produce(String template, Map<String, String> args);
}
