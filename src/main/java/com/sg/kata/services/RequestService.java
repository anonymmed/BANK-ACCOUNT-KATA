package com.sg.kata.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

    private final ObjectMapper objectMapper;

    @Autowired
    RequestService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public double parseAmountFromRequest(String request)  {
        double amount = 0.0;
        try {
            JsonNode node = this.objectMapper.readValue(request, ObjectNode.class);
            amount = node.get("amount").asDouble();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amount;
    }
}
