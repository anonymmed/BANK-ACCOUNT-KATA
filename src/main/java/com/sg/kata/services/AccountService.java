package com.sg.kata.services;

import com.sg.kata.models.Account;
import com.sg.kata.models.OperationType;
import com.sg.kata.models.Statement;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountService {

    public AccountService() {
    }

    public Account deposit(double amount, Account account) throws Exception {
        if (amount <= 0) {
            throw new Exception("Amount must be greater than 0");
        }
        // Setup the new account balance
         account.setBalance(account.getBalance() + amount);

        // Setup the statement for the operation
        Statement statement = new Statement(OperationType.DEPOSIT, new Date(), amount, account.getBalance());
        account.getStatements().add(statement);

        // Return the updated account
        return account;
    }

    public Account withdraw(double amount, Account account) throws Exception {
        if (account.getBalance() - amount < 0 || account.getBalance() == 0) {
            throw new Exception("Error! Insufficient funds");
        }
        if (amount <= 0) {
            throw new Exception("Amount must be greater than 0");
        }
        // Setup the new account balance
        account.setBalance(account.getBalance() - amount);

        // Setup the statement for the operation
        Statement statement = new Statement(OperationType.WITHDRAWAL, new Date(), amount, account.getBalance());
        account.getStatements().add(statement);

        // Return the updated account
        return account;
    }
}
