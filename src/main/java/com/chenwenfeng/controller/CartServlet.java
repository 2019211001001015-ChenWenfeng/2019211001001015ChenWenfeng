package com.chenwenfeng.controller;

import com.chenwenfeng.dao.ProductDao;
import com.chenwenfeng.model.Item;
import com.chenwenfeng.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartServlet",value = "/cart")
public class CartServlet extends HttpServlet {
    Connection conn  = null;

    public void init()
    {
        conn = (Connection) getServletContext().getAttribute("conn");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession(false);
        if(session!=null && session.getAttribute("user")!=null)
        {
            if (request.getParameter("action")==null)
            {
                displayCart(request,response);
            }else if(request.getParameter("action").equals("add"))
            {
                try {
                    buy(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else if(request.getParameter("action").equals("remove"))
            {
                remove(request,response);
            }
        }else {
            response.sendRedirect("login");
        }
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        int id =0;
        if (request.getParameter("productId")!=null)
        {
            id = Integer.parseInt(request.getParameter("productId"));

        }
        int index = isExisting(id,cart);
        cart.remove(index);
       session.setAttribute("cart",cart);
        String path = request.getContextPath()+"/cart";
        response.sendRedirect(path);
    }

    private void buy(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {


        HttpSession session = request.getSession();
        int id = request.getParameter("productId")!=null?Integer.parseInt(request.getParameter("productId")):0;
        int quantity = request.getParameter("quantity")!=null?Integer.parseInt(request.getParameter("quantity")):1;

        ProductDao productDao = new ProductDao();
        if (session.getAttribute("cart")==null)
        {
            List<Item> cart = new ArrayList<Item>();
            Product p = productDao.findById(id,conn);
            cart.add(new Item(p,quantity));
            session.setAttribute("cart",cart);
        }else{

            List<Item> cart = (List<Item>) session.getAttribute("cart");
            int index = isExisting(id,cart);
            if (index==-1)
            {
                Product p = productDao.findById(id,conn);
                cart.add(new Item(p,1));

            }else
            {
                int newQuantuty = cart.get(index).getQuantity()+1;
                cart.get(index).setQuantity(newQuantuty);
            }
            session.setAttribute("cart",cart);

        }

        response.sendRedirect(request.getContextPath()+"/cart");






    }

    private int isExisting(int id, List<Item> cart) {

        for(int i = 0;i < cart.size();i++)
        {
            if (cart.get(i).getProduct().getProductId()==id)
            {
                return i;
            }
        }
        return -1;
    }

    private void displayCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("message","Your Cart");
        String path = "/WEB-INF/views/cart.jsp";
        request.getRequestDispatcher(path).forward(request,response);


    }
}
