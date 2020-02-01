package ru.job4j.oo1.list;

public class SimpleQueue<T> {
    private SimpleStack<T> stack = new SimpleStack<>();
    private SimpleStack<T> queue = new SimpleStack<>();

    public T poll() {
        if (queue.linkedList.getSize() == 0) {
            while (stack.linkedList.getSize() > 0) {
                this.queue.push(this.stack.poll());
            }
        }
        return this.queue.poll();
    }

    public void push(T value) {
        this.stack.push(value);
    }
}
