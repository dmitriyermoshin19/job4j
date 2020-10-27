package ru.job4j.oo1multithreading.resourcesynchronization;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.oo1.list.ArrayList;

import java.util.Iterator;

/**
 * Collection for use in a multithreaded environment
 */
@ThreadSafe
public class SingleLockList<T> implements Iterable<T> {
    /**
     * collection for composition
     */
    @GuardedBy("this")
    private final ArrayList<T> array = new ArrayList<>();

    public synchronized void add(T value) {
        array.add(value);
    }

    public synchronized T get(int position) {
        return array.get(position);
    }

    /**
     * Iterator for a multithreaded collection
     */
    @Override
    public Iterator<T> iterator() {
        return copy().iterator();
    }

    /**
     * a copy of the data - snapshots
     */
    private synchronized ArrayList<T> copy() {
        ArrayList<T> copyArray = new ArrayList<>();
        array.forEach(copyArray::add);
        return copyArray;
    }
}
