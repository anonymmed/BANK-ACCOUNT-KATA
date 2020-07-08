package com.sg.kata.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sg.kata.contracts.IResponse;
import com.sg.kata.models.Account;
import com.sg.kata.models.OperationsResponse;
import com.sg.kata.models.StatementsResponse;
import com.sg.kata.services.AccountService;
import com.sg.kata.services.RequestService;
import com.sg.kata.services.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/API")
public class KataController {

    private final AccountService accountService;
    private final StatementService statementService;
    private final RequestService requestService;
    private final Account account;
    @Autowired
    public KataController(
            AccountService accountService,
            StatementService statementService,
            RequestService requestService
    ) {
        this.accountService = accountService;
        this.account = new Account(0.0);
        this.statementService = statementService;
        this.requestService = requestService;
    }

    @PostMapping("/deposit")
    public IResponse deposit(@RequestBody String body) throws JsonProcessingException {
        double amount = this.requestService.parseAmountFromRequest(body);
        OperationsResponse operationsResponse = new OperationsResponse();
        try {
            operationsResponse.setBalance(this.accountService.deposit(amount, this.account).getBalance());
            operationsResponse.setMessage("Operation has been successfully done");
        } catch (Exception e) {
            operationsResponse.setBalance(this.account.getBalance());
            operationsResponse.setMessage(e.getMessage());
        }
        return operationsResponse;
    }

    @PostMapping("/withdraw")
    public IResponse withdraw(@RequestBody String body) throws JsonProcessingException {
        double amount = this.requestService.parseAmountFromRequest(body);
        OperationsResponse operationsResponse = new OperationsResponse();
        try {
            operationsResponse.setBalance(this.accountService.withdraw(amount, this.account).getBalance());
            operationsResponse.setMessage("Operation has been successfully done");
        } catch (Exception e) {
            operationsResponse.setBalance(this.account.getBalance());
            operationsResponse.setMessage(e.getMessage());
        }
        return operationsResponse;
    }

    @RequestMapping(value = "/history")
    public IResponse history() {
        StatementsResponse statementsResponse = new StatementsResponse();
        try {
            statementsResponse.setMessage(this.statementService.getStatementHistory(this.account).toString());
        } catch (Exception e) {
            statementsResponse.setMessage(e.getMessage());
        }
        return statementsResponse;
    }


}
