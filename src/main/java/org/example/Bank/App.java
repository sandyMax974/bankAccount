package org.example.Bank;
import java.time.LocalDate;

public class App {
    public static void main(String args[]) throws ArithmeticException, IllegalArgumentException {
        try {
            Account bankAccount = new Account();
            // Given a client makes a deposit of 1000 on 2021-01-10
            bankAccount.deposit(500.00, LocalDate.of(2021, 1, 10));
            // And a deposit of 2000 on 2021-01-13
            bankAccount.deposit(100.00);
            // And a withdrawal of 500 on 2021-01-14
            bankAccount.withdraw(500.00, LocalDate.of(2021, 1, 14));
            // When she prints her bank statement
            bankAccount.printStatement();
            // A bit of fun with capability to add an overdraft
            bankAccount.modifyOverdraft(200.00);
            // Now she can withdraw extra
            bankAccount.withdraw(150.00, LocalDate.of(2021, 3, 24));
            // When she prints her bank statement
            bankAccount.printStatement();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
