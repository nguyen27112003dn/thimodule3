package com.example.thi.controller;

import com.example.thi.entity.Category;
import com.example.thi.entity.Product;
import com.example.thi.service.CategoryService;
import com.example.thi.service.ProductService;
import com.example.thi.service.imp.ICategoryService;
import com.example.thi.service.imp.IProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Product", value = "/products")
public class Controller extends HttpServlet {
    private IProductService iProductService = new ProductService();
    private ICategoryService iCategoryService = new CategoryService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                product(request, response);
                break;
            case "create":
                createProduct(request, response);
                break;
            case "deleteProduct":
                deleteProduct(request, response);
                break;
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = iCategoryService.findAll();
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int product_id = Integer.parseInt(request.getParameter("id"));
        iProductService.delete(product_id);
        request.getSession().setAttribute("successMessage", "Xóa sản phẩm thành công!");
        response.sendRedirect("/products");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                product(request, response);
                break;
            case "createProduct":
                creates(request, response);
                break;
        }
    }

    private void creates(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        String name_category = request.getParameter("category");
        Category category = new Category(name_category);
        Product product = new Product(name, price, quantity, color, description, category);
        iProductService.createProduct(product);
        try {
            HttpSession session = request.getSession();
            session.setAttribute("successMessage", "Thêm sản phẩm thành công!");
            response.sendRedirect("/products");
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    private void product(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = iProductService.findAll();
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product.jsp");
        dispatcher.forward(request, response);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


