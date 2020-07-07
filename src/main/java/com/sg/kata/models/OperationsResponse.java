package com.sg.kata.models;


import com.sg.kata.contracts.IResponse;

import java.util.Objects;

public class OperationsResponse implements IResponse {

    private String message;
    private double balance;

    public OperationsResponse() {
    }

    @Override
    public String toString() {
        return "OperationsResponse{" +
                "message='" + message + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationsResponse that = (OperationsResponse) o;
        return Double.compare(that.balance, balance) == 0 &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, balance);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
