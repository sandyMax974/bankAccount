package org.example.Bank;
import java.time.LocalDate;

public class Account {
    public final Transaction[] transactions;

    public Account(Transaction[] transactions) {
        this.transactions = transactions;
    }

    public static Integer getBalance() {
        return 1; // find a way to sum all transactions in account
    }

    public void deposit(Integer amount, LocalDate date) {
        Integer balanceAfterTransaction = getBalance() - amount;
        Transaction deposit_transaction = new Transaction(date, null, amount, balanceAfterTransaction);
        transactions += deposit_transaction;
    }
}
