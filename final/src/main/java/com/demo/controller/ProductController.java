package com.demo.controller;

import com.demo.DAO.*;
import com.demo.entity.*;
import com.demo.service.AccountService;
import com.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
   @Autowired
    ProductService productService;

   @Autowired ProductDAO productDAO;

    @Autowired
    ThuongHieuDAO mauSac;

    @RequestMapping("/home")
    public String home(){
        return "product/home";
    }

    @RequestMapping("/product/list")
    public String list(Model model, @RequestParam("cid")Optional<Long> cid){
        if(cid.isPresent()){
            List<Product> list = productService.findByCategoryId(cid.get());
            model.addAttribute("items",list);
        }else{
            List<Product> list = productService.findAll();
            model.addAttribute("items",list);
        }
        return "product/list";
    }

    @RequestMapping("/product/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id){
        Product product = productService.findById(id);
        model.addAttribute("items",product);
        return "product/detail";
    }

}
