package com.sg.kata.models;

import com.sg.kata.contracts.IResponse;

import java.util.Objects;

public class StatementsResponse implements IResponse {
    private String message;

    public StatementsResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatementsResponse that = (StatementsResponse) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }
}
