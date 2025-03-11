package com.example.thi.repository.imp;

import com.example.thi.entity.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> findAll();
}
