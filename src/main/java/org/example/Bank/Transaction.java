package org.example.Bank;
import java.time.LocalDate;

public class Transaction {

    public final LocalDate date;
    public final Double credit;
    public final Double debit;
    public final Double balance;

    public Transaction(LocalDate date, Double credit, Double debit, Double balance) {
        this.date = date;
        this.credit = credit;
        this.debit = debit;
        this.balance = balance;
    }

}
