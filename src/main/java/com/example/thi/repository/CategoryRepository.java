package com.example.thi.repository;

import com.example.thi.entity.Category;
import com.example.thi.repository.imp.ICategoryRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements ICategoryRepository {
    private final String SELECT_CATEGORY = "select * from Category";

    public List<Category> findAll() {
        List<Category> list = new ArrayList<>();
        try (
                Connection connection = BaseRepository.getConnection();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(SELECT_CATEGORY);
            while (resultSet.next()) {
                int id = resultSet.getInt("CategoryID");
                String name_category = resultSet.getString("CategoryName");
                Category category = new Category(id, name_category);
                list.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
