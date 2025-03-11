package com.example.thi.service;

import com.example.thi.entity.Product;
import com.example.thi.repository.ProductRepository;
import com.example.thi.repository.imp.IProductRepository;
import com.example.thi.service.imp.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private IProductRepository iProductRepository = new ProductRepository();

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void createProduct(Product product) {
        iProductRepository.createProduct(product);
    }

    @Override
    public void create(Product product) {
        iProductRepository.createProduct(product);
    }

    @Override
    public void delete(int id) {
        iProductRepository.delete(id);
    }
}
