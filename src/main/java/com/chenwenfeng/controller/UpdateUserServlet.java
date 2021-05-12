package com.chenwenfeng.controller;

import com.chenwenfeng.dao.IUserDao;
import com.chenwenfeng.dao.UserDao;
import com.chenwenfeng.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UpdateUserServlet",value = "/update")
public class UpdateUserServlet extends HttpServlet {

    Connection conn;
    @Override
    public void init(){

        conn = (Connection) getServletContext().getAttribute("conn");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        User user = new User();

       int id = Integer.valueOf(request.getParameter("id"));
       String username = request.getParameter("username");
       String password = request.getParameter("password");
       String email = request.getParameter("email");
       String gender = request.getParameter("gender");
        try {
            Date date = sdf.parse(request.getParameter("date"));
            user.setBirthDate(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(user!=null)
        {
            session.setAttribute("user",user);
        }

        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setGender(gender);


        IUserDao iUserDao = new UserDao();
        try {

           iUserDao.updateUser(conn,user);
           request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);


    }
}
