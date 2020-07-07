package com.sg.kata.services;


import com.sg.kata.models.Account;
import com.sg.kata.models.OperationType;
import com.sg.kata.models.Statement;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StatementServiceTests {

    private final StatementService statementService;
    private final AccountService accountService;

    @Autowired
    public StatementServiceTests(StatementService statementService, AccountService accountService) {
        this.statementService = statementService;
        this.accountService = accountService;
    }

    @Test
    public void getStatementHistoryTest() throws Exception {
        Account account = new Account(25.8);
        List<Statement> expected = new ArrayList<>();
        assertIterableEquals(expected, this.statementService.getStatementHistory(account));
        this.accountService.deposit(10, account);
        Statement statement = new Statement(OperationType.DEPOSIT, this.statementService.getStatementHistory(account).get(0).getDate(), 10,35.8);
        expected.add(statement);
        assertIterableEquals(expected, this.statementService.getStatementHistory(account));
    }

}
