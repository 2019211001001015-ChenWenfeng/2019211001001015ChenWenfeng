package com.chenwenfeng.controller;

import com.chenwenfeng.dao.ProductDao;
import com.chenwenfeng.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductListServlet",value = "/admin/productList")
public class ProductListServlet extends HttpServlet {

    Connection conn;
    @Override
    public void init(){

        conn = (Connection) getServletContext().getAttribute("conn");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/WEB-INF/views/admin/productList.jsp";
        request.getRequestDispatcher(path).forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        try {

            ProductDao productDao = new ProductDao();
            List<Product> productList = productDao.findAll(conn);
            request.setAttribute("productList",productList);


        } catch (SQLException e) {
            e.printStackTrace();
        }

        String path = "/WEB-INF/views/admin/productList.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }
}
