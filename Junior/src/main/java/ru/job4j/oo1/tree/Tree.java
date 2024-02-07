package ru.job4j.oo1.tree;

import java.util.*;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;


public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;
    private int size = 1;

    public Tree(final E value) {
        this.root = new Node<>(value);
    }

    /**
     * Метод добавляет любому существующему элементу дерева(ключ) дочерний элемент(значение) и образуется новая ветка.
     * Проверяет существует ли родительский элемент(должен существовать).
     * Проверяет существует ли дочерний элемент
     * (не обязательно должен существовать, если есть - дубликат не записывает).
     * Добавляет элемент в дерево.
     *
     * @param parent - элемент, к которому добавляется дочерний элемент.
     * @param child  - элемент который нужно добавить.
     * @return - результат добавления элемента:
     * (true - если родительский элемент существует, а дочерний отсутствует в дереве,
     * false - если родительский элемент не существует, или дочерний уже присутствует в дереве).
     */
    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Optional<Node<E>> parentNode = findBy(parent);
        if (parentNode.isPresent() && findBy(child).isEmpty()) {
            parentNode.get().add(new Node<E>(child));
            result = true;
            size++;
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(this.root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if (node.eqValue(value)) {
                rsl = Optional.of(node);
                break;
            }
            queue.addAll(node.getChildren());
        }
        return rsl;
    }

    /**
     * Метод проходит по каждому элементу дерева, и проверяет количество дочерних элементов.
     * Дерево считается бинарным, если у каждого элемента дерева не больше 2 дочерних.
     *
     * @return - результат проверки.
     * this в цикле for - это объект этого класса, в поле которого забиваются все дочерние ноды.
     * E value в цикле for - значение из next() из iterator()
     * значения которые были взяты из поля класса Node<E> root.
     * затем через метод findBy(value) мы находим ноду по значению value.
     * вытаскиваем из коробочки и сравниваем size коллекции children.
     */
    public boolean isBinary() {
        boolean result = true;
        for (E value : this) {
            Optional<Node<E>> rsl = this.findBy(value);
            Node<E> node = rsl.get();
            if (node.getChildren().size() > 2) {
                result = false;
                break;
            }
        }
        return result;
    }

    public class Node<E extends Comparable<E>> {
        private final List<Node<E>> children = new ArrayList<>();
        private final E value;

        public Node(final E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public void add(Node<E> child) {
            this.children.add(child);
        }

        public List<Node<E>> getChildren() {
            return this.children;
        }

        public boolean eqValue(E that) {
            return this.value.compareTo(that) == 0;
        }

        @Override
        public String toString() {
            return "Node{" + "value=" + value + ", children=" + children + '}';
        }
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            Queue<Node<E>> queue = new LinkedList<>(List.of(root));
            int indexIt;

            @Override
            public boolean hasNext() {
                return indexIt < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> node = queue.poll();
                queue.addAll(node.getChildren());
                indexIt++;
                return node.getValue();
            }
        };
    }
}
