package com.example.thi.entity;

public class Category {
    private int id;
    private String nameCategory;

    public Category(int id, String nameCategory) {
        this.id = id;
        this.nameCategory = nameCategory;
    }

    public Category(String nameCategory) {
        this.nameCategory = nameCategory;
    }


    public String getnameCategory() {
        return nameCategory;
    }

    public void setName_category(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
