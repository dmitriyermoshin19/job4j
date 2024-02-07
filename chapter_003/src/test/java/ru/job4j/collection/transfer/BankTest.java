package ru.job4j.collection.transfer;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BankTest {
    @Test
    public void transferMoneyTrue() {
        Bank bank = new Bank();
        bank.addUser(new User("srs", "1"));
        bank.addUser(new User("dst", "2"));
        bank.addAccountToUser("1", new Account(10, "11"));
        bank.addAccountToUser("2", new Account(0, "22"));
        boolean result = bank.transferMoney("1", "11", "2", "22", 10);
        assertThat(result, is(true));
    }

    @Test
    public void transferMoneyFalse() {
        Bank bank = new Bank();
        bank.addUser(new User("srs", "1"));
        bank.addUser(new User("dst", "2"));
        bank.addAccountToUser("10", new Account(10, "11"));
        bank.addAccountToUser("2", new Account(0, "22"));
        boolean result = bank.transferMoney("1", "11", "2", "22", 10);
        assertThat(result, is(false));
    }
}

