package com.sg.kata.models;

import com.sg.kata.models.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

public class StatementTests {

    @Test
    public void TestStatementModel() {
        Date operationDate = new Date();
        Statement statement = new Statement(OperationType.DEPOSIT, operationDate, 10 , 0);
        assertEquals(statement.getAmount(), 10);
        Statement statement1 = new Statement(OperationType.DEPOSIT, operationDate, 10 , 0);
        assertEquals(statement.getAmount(), statement1.getAmount());
        assertEquals(statement.getCurrentBalance(), statement1.getCurrentBalance());
        assertEquals(statement.hashCode(), statement1.hashCode());
        assertEquals(statement.toString(), statement1.toString());
        assertEquals(statement, statement1);
        assertEquals(statement.getDate(), statement1.getDate());
        assertEquals(statement.getOperation(), statement1.getOperation());
        statement.setCurrentBalance(20);
        statement.setAmount(20);
        Date updatedDate = new Date();
        statement.setDate(updatedDate);
        statement.setOperation(OperationType.WITHDRAWAL);
        assertEquals(statement.getDate(), updatedDate);
        assertEquals(statement.getOperation(), OperationType.WITHDRAWAL);
        assertEquals(statement.getCurrentBalance(), 20);
        assertEquals(statement.getCurrentBalance(), 20);

    }

}
