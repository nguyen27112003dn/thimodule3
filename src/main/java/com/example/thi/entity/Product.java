package com.example.thi.entity;

public class Product {

    private int id_product;
    private String name;
    private double price;
    private int quantity;
    private String color;
    private String description;
    private Category Category;

    public Product(int id_product, String name, double price, int quantity, String color, String description, Category Category) {
        this.id_product = id_product;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.Category = Category;
    }

    public Product(String name, Double price, int quantity, String color, Category Category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.Category = Category;
    }

    public int getProductID() {
        return id_product;
    }

    public void setProductID(int productID) {
        id_product = productID;
    }

    public String getProductName() {
        return name;
    }

    public void setProductName(String productName) {
        name = productName;
    }

    public double getProductPrice() {
        return price;
    }

    public void setProductPrice(double productPrice) {
        price = productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        color = color;
    }

    public String getProductDescription() {
        return description;
    }

    public void setProductDescription(String productDescription) {
        description = productDescription;
    }

    public com.example.thi.entity.Category getCategory() {
        return Category;
    }

    public void setCategory(com.example.thi.entity.Category category) {
        Category = category;
    }

    public Product() {
        super();
    }

}
