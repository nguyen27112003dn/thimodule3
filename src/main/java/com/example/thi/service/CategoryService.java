package com.example.thi.service;

import com.example.thi.entity.Category;
import com.example.thi.repository.CategoryRepository;
import com.example.thi.repository.imp.ICategoryRepository;
import com.example.thi.service.imp.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {
    private ICategoryRepository iCategoryRepository = new CategoryRepository();

    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }
}
