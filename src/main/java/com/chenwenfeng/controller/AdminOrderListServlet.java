package com.chenwenfeng.controller;

import com.chenwenfeng.dao.OrderDao;
import com.chenwenfeng.model.Order;
import com.chenwenfeng.model.Payment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "AdminOrderListServlet",value = "/admin/orderList")
public class AdminOrderListServlet extends HttpServlet {

    Connection conn  = null;

    public void init()
    {
        conn = (Connection) getServletContext().getAttribute("conn");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        List<Payment> paymentTypeList = Payment.findAllPayment(conn);
        request.setAttribute("paymentTypeList",paymentTypeList);
        OrderDao orderDao = new OrderDao();
        List<Order> orderList = orderDao.findAll(conn);
        request.setAttribute("orderList",orderList);
        String path = "/WEB-INF/views/admin/orderList.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }
}
