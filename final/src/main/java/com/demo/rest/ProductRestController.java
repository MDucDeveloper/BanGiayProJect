package com.demo.rest;


import com.demo.entity.Product;
import com.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {
    @Autowired
    ProductService productService;

    @GetMapping()
    public List<Product> getAll(){
        return productService.findAll();
    }

    @GetMapping("{id}")
    public Product getOne(@PathVariable("id") Long id){
        return productService.findById(id);
    }

    @PostMapping()
    public Product create(@RequestBody Product product){
//        int date = product.getNgaycapnhap().getMonth();
//        System.out.println(date);
        return productService.create(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable("id") Long id,@RequestBody Product product){
        return productService.update(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        productService.delete(id);
    }
}
