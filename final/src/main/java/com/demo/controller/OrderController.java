package com.demo.controller;

import com.demo.DAO.OderDetailDAO;
import com.demo.DAO.OrderDAO;
import com.demo.DAO.ProductDAO;
import com.demo.entity.Order;
import com.demo.entity.OrderDetail;
import com.demo.entity.Product;
import com.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderDAO dao;
    @Autowired
    ProductDAO pdao;
    @Autowired
    OderDetailDAO ddao;

    @RequestMapping("/cart/view")
    public String order(){
        return "cart/view";
    }

    @RequestMapping("/order/checkout")
    public String checkout(){
        return "order/checkout";
    }

    @RequestMapping("/order/list")
    public String list(Model model, HttpServletRequest request){
        String username = request.getRemoteUser();
        model.addAttribute("orders",orderService.fndByUsername(username));
        return "order/list";
    }

    @RequestMapping("/order/detail/{id}")
    public String detailorder(@PathVariable("id") Long id, Model model){
        model.addAttribute("order",orderService.fndById(id));
        return "order/detail";
    }
}
