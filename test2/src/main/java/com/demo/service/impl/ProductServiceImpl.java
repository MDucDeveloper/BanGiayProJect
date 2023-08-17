package com.demo.service.impl;

import com.demo.DAO.ProductDAO;
import com.demo.entity.Product;
import com.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDAO productDAO;
    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productDAO.findById(id).get();
    }

    @Override
    public List<Product> findByCategoryId(Long cid) {
        return productDAO.findbyCategoryId(cid);
    }

    @Override
    public Product create(Product product) {
        return productDAO.save(product);
    }

    @Override
    public Product update(Product product) {
        return productDAO.save(product);
    }

    @Override
    public void delete(Long id) {
         productDAO.deleteById(id);
    }
}
