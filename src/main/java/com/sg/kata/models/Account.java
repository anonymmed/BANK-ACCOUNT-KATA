package com.sg.kata.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account implements Serializable {

    private double balance;
    private transient List<Statement> statements;

    public Account(double balance) {
        this.balance = balance;
        this.statements = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(account.balance, balance) == 0 &&
                Objects.equals(statements, account.statements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, statements);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    @Override
    public String toString() {
        return "{" +
                "balance : "  + balance +
                "}";
    }

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }
}
