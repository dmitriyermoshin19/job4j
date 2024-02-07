package ru.job4j.sobes.javacor.seva.inerface;

interface ExtLib {
    void getSomething(ExtListener listener);
}

interface ExtListener {
    void onData(String data);
}

public interface InternalLib extends ExtLib, ExtListener {
    String getData();
}
