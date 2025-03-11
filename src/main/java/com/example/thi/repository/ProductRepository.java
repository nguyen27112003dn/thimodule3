package com.example.thi.repository;

import com.example.thi.entity.Category;
import com.example.thi.entity.Product;
import com.example.thi.repository.imp.IProductRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private final String SELECT = "SELECT p.ProductID, p.ProductName, p.Price, p.Quantity, p.Color, p.Description, c.CategoryID, c.CategoryName " +
            "FROM Product p JOIN Category c ON p.CategoryID = c.CategoryID";
    private final String INSERT = "INSERT INTO Product (ProductName, Price, Quantity, Color, Description, CategoryID) VALUES \n" +
            "(?, ?, ?, ?, ?, ?)";
    private final String DELETE = "delete from Product where ProductID = ?";


    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnection();
             Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery(SELECT);
            while (resultSet.next()) {
                int id_product = resultSet.getInt("ProductID");
                String name = resultSet.getString("ProductName");
                Double price = resultSet.getDouble("Price");
                int quantity = resultSet.getInt("Quantity");
                String color = resultSet.getString("Color");
                String description = resultSet.getString("Description");
                int id = resultSet.getInt("CategoryID");
                String type = resultSet.getString("CategoryName");
                Category category = new Category(type);
                Product product = new Product(id_product, name, price, quantity, color, description, category);
                list.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void createProduct(Product product) {
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
        ) {
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setDouble(2, product.getProductPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getProductDescription());
            preparedStatement.setString(6, product.getCategory().getnameCategory());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
        ) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}