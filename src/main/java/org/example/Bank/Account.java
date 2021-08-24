package org.example.Bank;
import java.time.LocalDate;

public class Account {
//    public static Transaction[] transactions;
    public Account() {
//        transactions = new Transaction[0];
    }

    public static Integer getBalance() {
        return 1; // find a way to sum all transactions in account
    }

    public static void addTransactionToAccount(Transaction transaction) {
//        transactions += transaction; // ERROR with type
    }

    public void deposit(Double amount, LocalDate date) {
        Double balanceAfterTransaction = getBalance() - amount;
        Transaction deposit_transaction = new Transaction(date, null, amount, balanceAfterTransaction);
//        transactions += deposit_transaction; --> addTransactionToAccount(Transaction transaction)
    }
}
