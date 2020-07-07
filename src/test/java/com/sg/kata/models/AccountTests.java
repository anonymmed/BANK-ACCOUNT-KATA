package com.sg.kata.models;

import com.sg.kata.models.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

public class AccountTests {

    @Test
    public void TestAccountModel() {
        Account account = new Account(10.5);
        assertEquals(account.getBalance(), 10.5);
        Account account1 = new Account(0);
        account1.setBalance(account.getBalance());
        account1.setStatements(account.getStatements());
        assertEquals(account.getStatements(), new ArrayList<Statement>());
        assertEquals(account.hashCode(), account1.hashCode());
        assertEquals(account.toString(), account1.toString());
        assertEquals(account, account1);

    }
}
