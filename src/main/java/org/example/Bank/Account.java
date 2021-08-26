package org.example.Bank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class Account {
    public static ArrayList<Transaction> transactions;

    public Account() {
        transactions = new ArrayList<Transaction>();
    }

    public Double getCurrentBalance() {
        Double currentBalance = 0.00;
        for (Integer i = 0; i < transactions.size(); i++) {
            if(transactions.get(i).getTransactionCredit() != null) { currentBalance += transactions.get(i).getTransactionCredit(); }
            if(transactions.get(i).getTransactionDebit() != null) { currentBalance -= transactions.get(i).getTransactionDebit(); }
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
        String statementHeader = "date || credit || debit || balance";
        System.out.println(statementHeader);
        //sort transactions array in asc order based on date Collections.sort(myNumbers);
        transactions.sort(Comparator.comparing(Transaction::getTransactionDate).reversed());
        //store each line data into variable
        for(int i = 0; i < transactions.size(); i++) {
            String statementLineDate = String.valueOf(transactions.get(i).getTransactionDate());
            String statementLineBalance = String.valueOf(transactions.get(i).getBalanceAfterTransaction());

            String statementLineCredit;
            if(transactions.get(i).getTransactionCredit() == null) {
                statementLineCredit = "-";
            } else {
                statementLineCredit = String.valueOf(transactions.get(i).getTransactionCredit());
            }

            String statementLineDebit;
            if(transactions.get(i).getTransactionDebit() == null) {
                statementLineDebit = "-";
            } else {
                statementLineDebit = String.valueOf(transactions.get(i).getTransactionDebit());
            }
            //define the statement template
            String statementLine = String.format("%s || %s || %s || %s",statementLineDate, statementLineCredit,statementLineDebit,statementLineBalance);
            System.out.println(statementLine);
        }
    }
}
