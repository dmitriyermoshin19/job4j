package ru.job4j.oo1multithreading.nonblockingalgoritm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BaseCache {
    private final Map<Integer, Base> cache = new ConcurrentHashMap<>();

    public void add(Base base) {
        cache.putIfAbsent(base.getId(), base);
    }

    public void update(Base base) {
        cache.computeIfPresent(base.getId(), (key, oldBase) -> {
            if (base.getVersion() != oldBase.getVersion()) {
                throw new OptimisticException("Invalid version");
            }
            oldBase.setVersion(oldBase.getVersion() + 1);
            oldBase.setName(base.getName());
            return oldBase;
        });
    }

    public Base delete(Base base) {
        return cache.remove(base.getId());
    }

}

