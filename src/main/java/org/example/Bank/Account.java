package org.example.Bank;
import java.time.LocalDate;
import java.util.ArrayList;

public class Account {
    public static ArrayList<Transaction> transactions;

    public Account() {
        transactions = new ArrayList<Transaction>();
    }

    public static Double getBalance() {
        Double currentBalance = null;
        for (Integer i = 0; i < transactions.size(); i++) {
            currentBalance += transactions.get(i).credit;
            currentBalance += transactions.get(i).debit;
        }
        if (currentBalance == null) {
            return 0.00;
        } else {
            return currentBalance; // find a way to sum all transactions in account
        }
    }

    public static void addTransactionToAccount(Transaction transaction) {
        transactions.add(transaction);
    }

    public void deposit(Double amount, LocalDate date) {
        Double balanceAfterTransaction = getBalance() + amount;
        Transaction deposit_transaction = new Transaction(date, null, amount, balanceAfterTransaction);
        addTransactionToAccount(deposit_transaction);
    }

    public void withdraw(Double amount, LocalDate date) {
        Double balanceAfterTransaction = getBalance() - amount;
        Transaction deposit_transaction = new Transaction(date, -amount, null, balanceAfterTransaction);
        addTransactionToAccount(deposit_transaction);
    }
}
