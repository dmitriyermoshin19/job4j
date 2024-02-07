package ru.job4j.oo1multithreading.resourcesynchronization;

import org.junit.Assert;
import org.junit.Test;

public class UserStorageTest {

    @Test
    public void whenTransfer() {
        UserStorage storage = new UserStorage();
        User from = new User(1, 100);
        User to = new User(2, 100);
        storage.add(from);
        storage.add(to);
        storage.transfer(from.getId(), to.getId(), 50);
        Assert.assertEquals(50, from.getAmount());
        Assert.assertEquals(150, to.getAmount());
    }

    @Test
    public void whenUpdate() {
        UserStorage storage = new UserStorage();
        User from = new User(1, 100);
        User to = new User(1, 200);
        storage.add(from);
        storage.update(to);
        User user = storage.findById(from.getId());
        Assert.assertEquals(200, user.getAmount());
    }
}