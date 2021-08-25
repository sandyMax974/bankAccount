package org.example.Bank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class Account {
    public static ArrayList<Transaction> transactions;

    public Account() {
        transactions = new ArrayList<Transaction>();
    }

    public Double getCurrentBalance() {
        Double currentBalance = 0.00;
        for (Integer i = 0; i < transactions.size(); i++) {
            if(transactions.get(i).credit != null) { currentBalance += transactions.get(i).credit; }
            if(transactions.get(i).debit != null) { currentBalance -= transactions.get(i).debit; }
        }
        return currentBalance;
    }

    public void addTransactionToAccount(Transaction transaction) {
        transactions.add(transaction);
    }

    public void withdraw(Double amount, LocalDate date) {
        Double balanceAfterTransaction = getCurrentBalance() - amount;
        Transaction deposit_transaction = new Transaction(date, null, amount, balanceAfterTransaction);
        addTransactionToAccount(deposit_transaction);
    }

    public void deposit(Double amount, LocalDate date) {
        Double balanceAfterTransaction = getCurrentBalance() + amount;
        Transaction deposit_transaction = new Transaction(date, amount, null, balanceAfterTransaction);
        addTransactionToAccount(deposit_transaction);
    }


    public void printStatement() {
        //printStatementHeader(); => to be defined, separate class Statement
        //sort transactions array in asc order based on date Collections.sort(myNumbers);
        transactions.sort(Comparator.comparing(Transaction::getTransactionDate).reversed());
        for(int i = 0; i < transactions.size(); i++) {
            System.out.println(transactions.get(i).date);
            System.out.println(transactions.get(i).balance);
        }
        //store each line data into variable
        //define the statement template
    }
}
