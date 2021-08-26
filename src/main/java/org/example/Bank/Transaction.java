package org.example.Bank;
import java.time.LocalDate;

public class Transaction {

    private final LocalDate date;
    private final Double credit;
    private final Double debit;
    private final Double balance;

    public Transaction(LocalDate date, Double credit, Double debit, Double balance) {
        this.date = date;
        this.credit = credit;
        this.debit = debit;
        this.balance = balance;
    }

    public LocalDate getTransactionDate() {
        return this.date;
    }
    public Double getTransactionCredit() {
        return this.credit;
    }
    public Double getTransactionDebit() {
        return this.debit;
    }
    public Double getBalanceAfterTransaction() {
        return this.balance;
    }


}
