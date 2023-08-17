package com.demo.service.impl;

import com.demo.DAO.AccountDAO;
import com.demo.DAO.OrderDAO;
import com.demo.DAO.OderDetailDAO;
import com.demo.entity.Account;
import com.demo.entity.Order;
import com.demo.entity.OrderDetail;
import com.demo.service.OrderService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDAO dao;

    @Autowired OderDetailDAO ddao;

    @Autowired
    AccountDAO adao;

    @Override
    public Order create(JsonNode orderData) {
        ObjectMapper mapper = new ObjectMapper();

        Order order = mapper.convertValue(orderData,Order.class);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Account account = adao.findById(username).orElse(null);
        order.setAccount(account);
        dao.save(order);

        TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {};
        List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"),type)
                .stream().peek(d->d.setOrder(order)).collect(Collectors.toList());
        ddao.saveAll(details);

        return order;
    }

    @Override
    public Order fndById(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public List<Order> fndByUsername(String username) {
        return dao.findByUsername(username);
    }
}
