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
    @RequestMapping("/about")
    public String about(){
        return "product/about";
    }
    @RequestMapping("/contact")
    public String contact(){
        return "product/contact";
    }
    @RequestMapping("/news")
    public String news(){
        return "product/news";
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

    @RequestMapping("/product/lists")
    public String listfindByReferences(Model model,
                                       @RequestParam("priceFrom")Optional<String> priceFrom,
                                       @RequestParam("priceTo")Optional<String> priceTo,
                                       @RequestParam("brands")Optional<String> brands,
                                       @RequestParam("sizes")Optional<String> sizes,
                                       @RequestParam("colors")Optional<String> colors){
        System.out.println(priceFrom.get()+"/"+priceTo.get()+"/"+brands.get()+"/"+sizes.get()+"/"+colors.get());
        Double pricefrom = null;
        Double priceto = null;
        Long idsize = null;
        Long idbrand = null;
        Long idcolor = null;
        if(priceFrom.get().equals("")){
            pricefrom = null;
        }else{
            pricefrom = Double.parseDouble(priceFrom.get());
        }
        if(priceTo.get().equals("")){
            priceto = null;
        }else{
            priceto = Double.parseDouble(priceTo.get());
        }
        if(sizes.get().equals("")){
            idsize = null;
        }else{
            idsize = Long.parseLong(sizes.get());
        }
        if(brands.get().equals("")){
            idbrand = null;
        }else{
            idbrand = Long.parseLong(brands.get());
        }
        if(colors.get().equals("")){
            idcolor = null;
        }else{
            idcolor = Long.parseLong(colors.get());
        }
        if(priceFrom.get().isEmpty() && priceTo.get().isEmpty()
                && brands.get().isEmpty()
                && sizes.get().isEmpty()
                && colors.get().isEmpty()){
            List<Product> list = productService.findAll();
            model.addAttribute("items",list);
            return "product/list";
        }
        if(priceFrom.get().isEmpty() || priceTo.get().isEmpty()){

            List<Product> list = productService.find3References(idbrand,idsize,idcolor);
            model.addAttribute("items",list);
            return "product/list";
        }else
        {
            List<Product> list = productService.findAllReferences(pricefrom,priceto,idbrand,idsize,idcolor);
            model.addAttribute("items",list);
            return "product/list";
        }

    }

    @RequestMapping("/product/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id){
        Product product = productService.findById(id);
        model.addAttribute("items",product);
        return "product/detail";
    }

}
