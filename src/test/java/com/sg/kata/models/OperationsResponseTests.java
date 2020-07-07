package com.sg.kata.models;

import com.sg.kata.models.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

public class OperationsResponseTests {

    @Test
    public void TestOperationsResponseModel() {
        OperationsResponse operationsResponse = new OperationsResponse();
        operationsResponse.setBalance(0);
        operationsResponse.setMessage("");
        assertEquals(operationsResponse.getBalance(), 0);
        OperationsResponse operationsResponse1 = new OperationsResponse();
        operationsResponse1.setBalance(0);
        operationsResponse1.setMessage("");
        assertEquals(operationsResponse.getBalance(), operationsResponse1.getBalance());
        assertEquals(operationsResponse.getMessage(), operationsResponse1.getMessage());
        assertEquals(operationsResponse.hashCode(), operationsResponse1.hashCode());
        assertEquals(operationsResponse.toString(), operationsResponse1.toString());
        assertEquals(operationsResponse, operationsResponse1);

    }

}
