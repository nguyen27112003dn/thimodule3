package com.example.thi.service.imp;

import com.example.thi.entity.Category;
import com.example.thi.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void createProduct(Product product);

    void create(Product product);

    void delete(int id);
}
