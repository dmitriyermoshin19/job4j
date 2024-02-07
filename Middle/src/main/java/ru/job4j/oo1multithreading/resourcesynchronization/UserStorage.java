package ru.job4j.oo1multithreading.resourcesynchronization;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;

@ThreadSafe
public class UserStorage {
    @GuardedBy("this")
    private final Map<Integer, User> users = new HashMap<>();

    public synchronized boolean add(User user) {
        return users.putIfAbsent(user.getId(), user) != user;
    }

    public synchronized boolean update(User user) {
        users.replace(user.getId(), users.get(user.getId()), user);
        return true;
    }

    public synchronized User findById(int id) {
        return users.get(id);
    }

    public synchronized boolean delete(User user) {
        return users.remove(user.getId()) != null;
    }

    public synchronized void transfer(int fromId, int toId, int amount) {
        User source = users.get(fromId);
        User target = users.get(toId);
        if (source == null || target == null || source.getAmount() < amount) {
            return;
        }
        source.setAmount(source.getAmount() - amount);
        target.setAmount(target.getAmount() + amount);
    }
}
