package com.sg.kata.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RequestServiceTests {

    private final RequestService requestService;

    @Autowired
    public RequestServiceTests(RequestService requestService) {
        this.requestService = requestService;
    }

    @Test
    public void parseAmountFromRequestTest() throws JsonProcessingException {
        String body = "{\n" + "\"amount\" : 10.025\n" + "}";
        assertEquals(this.requestService.parseAmountFromRequest(body), 10.025);
    }

}
