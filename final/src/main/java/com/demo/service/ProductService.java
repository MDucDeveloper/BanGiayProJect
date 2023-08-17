package com.demo.service;

import com.demo.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Long id);

    List<Product> findByCategoryId(Long cid);

    Product create(Product product);

    Product update(Product product);

    void delete(Long id);
}
