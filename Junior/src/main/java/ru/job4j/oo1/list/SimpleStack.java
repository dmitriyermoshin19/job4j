package ru.job4j.oo1.list;

public class SimpleStack<T> {
    private LinkedList<T> linkedList = new LinkedList<>();

    public T poll() {
        return linkedList.delete();
    }

    public void push(T value) {
        linkedList.add(value);
    }
}
