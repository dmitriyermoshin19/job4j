package ru.job4j.sobes.javacor.algoritmi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * банкомат принимает запрашиваемую сумму
 * должен отдать количество имеющихся купюр равной сумме
 */
public class ATM {
    private Map<Integer, Integer> availableNotes;

    public ATM() {
        // Инициализация банкомата купюрами разных номиналов
        availableNotes = new HashMap<>();
        availableNotes.put(100, 10);
        availableNotes.put(50, 20);
        availableNotes.put(20, 30);
        availableNotes.put(10, 50);
    }

    // Метод для проверки доступного баланса банкомата
    public int checkBalance() {
        int balance = 0;
        for (Map.Entry<Integer, Integer> entry : availableNotes.entrySet()) {
            balance += entry.getKey() * entry.getValue();
        }
        return balance;
    }

    // Метод для пополнения банкомата купюрами из списка
    public void deposit(List<Integer> depositNotes) {
        for (int denomination : depositNotes) {
            if (isValidDenomination(denomination)) {
                // Пополните количество купюр данного номинала в банкомате
                int currentCount = availableNotes.getOrDefault(denomination, 0);
                availableNotes.put(denomination, currentCount + 1);
            } else {
                System.out.println("Недопустимый номинал купюры: " + denomination);
                // Здесь вы можете добавить логику обработки недопустимых купюр, если это необходимо
            }
        }
    }

    // Метод для проверки допустимости номинала купюры
    private boolean isValidDenomination(int denomination) {
        return (denomination == 50 || denomination == 100 || denomination == 500 || denomination == 1000);
    }

    // Метод для снятия средств с банкомата
    public Map<Integer, Integer> withdraw(int amount) {
        Map<Integer, Integer> withdrawnNotes = new HashMap<>();
        int remainingAmount = amount;

        // Перебираем номиналы купюр в порядке убывания
        int[] noteDenominations = {100, 50, 20, 10};
        for (int denomination : noteDenominations) {
            int notesToWithdraw = Math.min(remainingAmount / denomination, availableNotes.get(denomination));
            if (notesToWithdraw > 0) {
                withdrawnNotes.put(denomination, notesToWithdraw);
                availableNotes.put(denomination, availableNotes.get(denomination) - notesToWithdraw);
                remainingAmount -= notesToWithdraw * denomination;
            }
        }

        // Если не удалось выдать запрашиваемую сумму
        if (remainingAmount > 0) {
            System.out.println("Недостаточно средств в банкомате для выдачи запрошенной суммы.");
            return null;
        }

        return withdrawnNotes;
    }

    public static void main(String[] args) {
        ATM atm = new ATM();

        // Проверка баланса банкомата
        System.out.println("Баланс банкомата: " + atm.checkBalance());

        // Снятие средств с банкомата
        int withdrawalAmount = 240;
        Map<Integer, Integer> withdrawnNotes = atm.withdraw(withdrawalAmount);
        if (withdrawnNotes != null) {
            System.out.println("Выданы следующие купюры:");
            for (Map.Entry<Integer, Integer> entry : withdrawnNotes.entrySet()) {
                System.out.println(entry.getKey() + " рублей x " + entry.getValue());
            }
        }

        // Проверка баланса банкомата после снятия средств
        System.out.println("Баланс банкомата после снятия средств: " + atm.checkBalance());
    }
}
