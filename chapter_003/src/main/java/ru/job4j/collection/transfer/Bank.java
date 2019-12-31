package ru.job4j.collection.transfer;
import java.util.*;

public class Bank {
    private Map<User, ArrayList<Account>> users = new HashMap<>();

    public void addUser(User user) {
        this.users.put(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        this.users.remove(user);
    }

    public User getUser(String passport) {
        User user = null;
        for (User u: this.users.keySet()) {
            if (u.getPassport().equals(passport)) {
                user = u;
            }
        }
        return user;
    }

    public void addAccountToUser(String passport, Account account) {
        if (getUser(passport) != null) {
            this.users.get(getUser(passport)).add(account);
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        if (getUser(passport) != null) {
            this.users.get(getUser(passport)).remove(account);
        }
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> accounts = new ArrayList<>();
        if (getUser(passport) != null) {
            accounts = this.users.get(getUser(passport));
        }
        return accounts;
    }

    public Account getAccount(String passport, String requisite) {
        Account result = null;
        List<Account> accounts = getUserAccounts(passport);
        for (Account account : accounts) {
            if (account.getRequisites().equals(requisite)) {
                result = account;
                break;
            }
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String dstPassport, String dstRequisite, double amount) {
            boolean success = false;
            Account srcAccount = this.getAccount(srcPassport, srcRequisite);
            Account dstAccount = this.getAccount(dstPassport, dstRequisite);
            if (srcAccount != null && dstAccount != null) {
                double srcValue = srcAccount.getValue();
                double dstValue = dstAccount.getValue();
                if (amount > 0 && srcValue >= amount) {
                    srcValue -= amount;
                    srcAccount.setValue(srcValue);
                    dstValue += amount;
                    dstAccount.setValue(dstValue);
                    success = true;
                }
            }
        return success;
    }

    public String toString() {
        return "Bank{" + "accounts=" + users + "}";
    }
}
