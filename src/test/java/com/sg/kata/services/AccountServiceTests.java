package com.sg.kata.services;

import com.sg.kata.models.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AccountServiceTests {

    private final AccountService accountService;

    @Autowired

    public AccountServiceTests(AccountService accountService) {
        this.accountService = accountService;
    }

    @Test
    public void depositSuccessfulTest() throws Exception {
        Account mockAccount = new Account(10);
        Account updatedAccount = this.accountService.deposit(10.000005, mockAccount);
        assertEquals(20.000005, updatedAccount.getBalance());
        assertEquals(updatedAccount, mockAccount);
        assertDoesNotThrow(() -> this.accountService.deposit(10.000005, mockAccount));
    }

    @Test
    public void depositErrorTest() {
        Account mockAccount = new Account(10);
        assertThrows(
                Exception.class,
                () -> this.accountService.deposit(0, mockAccount),
                "Amount must be greater than 0"
        );
    }

    @Test
    public void withdrawSuccessfulTest() throws Exception {
        Account mockAccount = new Account(10);
        Account updatedAccount = this.accountService.withdraw(2.5, mockAccount);
        assertEquals(7.5, updatedAccount.getBalance());
        assertEquals(updatedAccount, mockAccount);
        assertDoesNotThrow(() -> this.accountService.withdraw(2.5, mockAccount));
    }
    @Test
    public void withdrawErrorTest() {
        Account mockAccount = new Account(0);
        assertThrows(
                Exception.class,
                () -> this.accountService.withdraw(0, mockAccount),
                "Error! Insufficient funds"
        );
        mockAccount.setBalance(10);
        assertThrows(
                Exception.class,
                () -> this.accountService.withdraw(10.001, mockAccount),
                "Error! Insufficient funds"
        );

        assertThrows(
                Exception.class,
                () -> this.accountService.withdraw(-1, mockAccount),
                "Amount must be greater than 0"
        );
    }

}
