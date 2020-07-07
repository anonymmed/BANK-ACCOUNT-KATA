package com.sg.kata.models;

import com.sg.kata.models.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

public class StatementResponseTests {

    @Test
    public void TestStatementResponseModel() {
        StatementsResponse statementsResponse = new StatementsResponse();
        StatementsResponse statementsResponse1 = new StatementsResponse();
        statementsResponse.setMessage("");
        statementsResponse1.setMessage("");
        assertEquals(statementsResponse.getMessage(), "");
        assertEquals(statementsResponse, statementsResponse1);
        assertEquals(statementsResponse.hashCode(), statementsResponse1.hashCode());
        assertEquals(statementsResponse.toString(), statementsResponse1.toString());

    }
}
