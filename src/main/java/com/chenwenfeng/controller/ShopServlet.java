package com.chenwenfeng.controller;

import com.chenwenfeng.dao.ProductDao;
import com.chenwenfeng.model.Category;
import com.chenwenfeng.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ShopServlet",value = "/shop")
public class ShopServlet extends HttpServlet {
    Connection conn = null;

    public void init() {
        conn = (Connection) getServletContext().getAttribute("conn");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<Category> categoryList = Category.findAll(conn);
            request.setAttribute("categoryList", categoryList);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ProductDao productDao = new ProductDao();
        try {
            if (request.getParameter("categoryId") == null) {
                List<Product> productList = productDao.findAll(conn);
                request.setAttribute("productList", productList);
            } else {

                int cateId = Integer.parseInt(request.getParameter("categoryId"));
                List<Product> productList = productDao.findByCategoryId(cateId, conn);
                request.setAttribute("productList", productList);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String path = "/WEB-INF/views/shop.jsp";
        request.getRequestDispatcher(path).forward(request, response);

    }
}
