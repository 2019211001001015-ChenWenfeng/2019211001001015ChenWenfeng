package com.chenwenfeng.controller;

import com.chenwenfeng.dao.OrderDao;
import com.chenwenfeng.model.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "OrderDetailsServlet",value = "/orderDetails")
public class OrderDetailsServlet extends HttpServlet {
    Connection conn  = null;

    public void init()
    {
        conn = (Connection) getServletContext().getAttribute("conn");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int orderId = request.getParameter("orderId")!=null?Integer.parseInt(request.getParameter("orderId")):0;
        Item item = new Item();
        OrderDao orderDao = new OrderDao();
        List<Item> itemList = orderDao.findItemsByOrderId(conn,orderId);
        request.setAttribute("itemList",itemList);
        String path = "orderDetails.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }
}
