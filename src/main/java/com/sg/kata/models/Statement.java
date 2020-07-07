package com.sg.kata.models;

import java.util.Date;
import java.util.Objects;

public class Statement {
    private OperationType operation;
    private Date date;
    private double amount;
    private double currentBalance;

    public Statement(OperationType operation, Date date, double amount, double currentBalance) {
        this.operation = operation;
        this.date = date;
        this.amount = amount;
        this.currentBalance = currentBalance;
    }

    @Override
    public String toString() {
        return "{" +
                "\"operation\" : " + "\"" + operation +"\""+
                ", \"date\" : " + "\"" + date + "\"" +
                ", \"amount\" : " + "\"" + amount + "\"" +
                ", \"balance\" : " + "\"" + currentBalance + "\"" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statement statement = (Statement) o;
        return Double.compare(statement.amount, amount) == 0 &&
                Double.compare(statement.currentBalance, currentBalance) == 0 &&
                operation == statement.operation &&
                Objects.equals(date, statement.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, date, amount, currentBalance);
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public OperationType getOperation() {
        return operation;
    }

    public void setOperation(OperationType operation) {
        this.operation = operation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
