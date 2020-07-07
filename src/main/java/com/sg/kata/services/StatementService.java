package com.sg.kata.services;

import com.sg.kata.models.Account;
import com.sg.kata.models.Statement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatementService {

    public List<Statement> getStatementHistory(Account account) {
        return account.getStatements();
    }
}
