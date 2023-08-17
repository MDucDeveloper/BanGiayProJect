package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @RequestMapping({"/","/home/index"})
    public String home(){
        return "redirect:/home";
    }

    @RequestMapping({"/admin","/admin/home/index"})
    public String admin(){
        return "redirect:/assets/admin/index.html";
    }

    @GetMapping("/admin/product/index")
    public String listProduct(Model model){
//        model.addAttribute("listProduct",productService.getAll());
        return "admin/product/index";
    }
}
