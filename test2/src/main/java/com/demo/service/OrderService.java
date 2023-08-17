package com.demo.service;

import com.demo.entity.Order;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public interface OrderService {
    Order create(JsonNode orderData);

    Order fndById(Long id);

    List<Order> fndByUsername(String username);
}
