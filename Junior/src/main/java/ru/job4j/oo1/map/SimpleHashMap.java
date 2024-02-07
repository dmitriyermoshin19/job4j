package ru.job4j.oo1.map;

import java.util.*;

public class SimpleHashMap<K, V> implements Iterable<K> {
    /**
     * дефолтный ленч не перезаписывается, поэтому делаем новый.
     */
    private int tableLength = 4;
    /**
     * Чем меньше длина, тем больше вероятность коллизий.
     */
    private Node[] table = new Node[tableLength];
    /**
     * добавляем счетчик из-за увеличения длины таблицы для итератора.
     */
    private int modCount;
    private int size;

    public Node[] getTable() {
        return table;
    }

    /**
     * Метод возвращает длину фактически заполненного массива с пустыми ячейками внутри него.
     * В счетчике this.size только увеличение.
     */
    public int getSizeKeys() {
        return this.size;
    }

    /**
     * Расчет хэша для ключа.
     * key.hashCode() Получаем хэш код ключа.
     * (h >>> 16) Сдвигаем старшие разряды начального хэш кода ключа вправо на 16 позиций
     * (^ побитовое логическое или)
     */
    private int hash(K key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    /**
     * Метод нахождения индекса элемента в table в зависимости от длины массива.
     */
    int getIndex(K key) {
        return (this.tableLength - 1) & hash(key);
    }

    /**
     * Предусмотрите возможность роста хэш-таблицы при нехватке места для нового элемента.
     * Перехеширование ключей из-за изменения длины массива.
     */
    private void increaseTable() {
        if (this.getSizeKeys() == this.table.length) {
            this.tableLength *= 2;
            Node[] newContainer = new Node[this.tableLength];
            for (Node<K, V> node : this.table) {
                if (node != null) {
                    int index = this.getIndex(node.key);
                    newContainer[index] = node;
                }
            }
            this.table = null;
            this.table = newContainer;
            this.modCount++;
        }
    }

    /**
     * проверка искомой ячейки по ключу на пустоту.
     * проверка одинакового ключа по equals.
     * если одинаковые, то - true.
     */
    public boolean checkKey(K key) {
        var result = false;
        if (this.table[this.getIndex(key)] != null) {
            result = this.table[this.getIndex(key)].getKey().equals(key);
        }
        return result;
    }

    /**
     * Методы разрешения коллизий реализовывать не надо.
     * если есть подобный ключ, то перезаписать значение.
     */
    public boolean insert(K key, V value) {
        var result = false;
        this.increaseTable();
        int index = getIndex(key);
        if (table[index] == null || checkKey(key)) {
            table[index] = new Node<K, V>(key, value);
            result = true;
            size++;
        }
        return result;
    }

    /**
     * Достаем из таблицы ноду по ключу и из нее достаем значение.
     *
     * @param key
     * @return V value.
     */
    public V get(K key) {
        V result = null;
        if (checkKey(key)) {
            result = (V) this.table[this.getIndex(key)].getValue();
        }
        return result;
    }

    public boolean delete(K key) {
        var result = false;
        int index = getIndex(key);
        if (table[index] != null && checkKey(key)) {
            table[index] = null;
            result = true;
        }
        return result;
    }

    /**
     * Структура для хранения пары ключ-значение.
     * В рамках учебной задачи связанные списки для разрешения коллизий не используются.
     */
    static class Node<K, V> {
        private K key;
        private V value;
        //Node<K,V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        /**
         * переопределяем toString() для отображения ноды в консоли в тесте.
         */
        @Override
        public String toString() {
            return "Node{" + "key=" + key + ", value=" + value + '}';
        }
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int expectedModCount = modCount;
            int indexIt;

            /**
             * метод с пропуском пустых ячеек.
             * и находит следующую ячейку для next().
             */
            @Override
            public boolean hasNext() {
                var result = false;
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                for (int i = indexIt; i < table.length; i++) {
                    if (table[i] != null) {
                        indexIt = i;
                        result = true;
                        break;
                    }
                }
                return result;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (V) table[indexIt++].getValue();
            }
        };
    }
}
