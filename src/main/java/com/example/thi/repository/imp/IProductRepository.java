package com.example.thi.repository.imp;

import com.example.thi.entity.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> findAll();

    void createProduct(Product product);

    void delete(int id);


}
