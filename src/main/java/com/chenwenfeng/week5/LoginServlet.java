package com.chenwenfeng.week5;

import com.chenwenfeng.dao.UserDao;
import com.chenwenfeng.model.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
    Connection conn;
    @Override
    public void init(){
//        ServletContext context = config.getServletContext();
//        String driver = context.getInitParameter("driver");
//        String url = context.getInitParameter("url");
//        String username = context.getInitParameter("username");
//        String password = context.getInitParameter("password");
//
//        try {
//            Class.forName(driver);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        // 建立数据库连接，获得连接对象conn
//        try {
//            conn = DriverManager.getConnection(url, username,password);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
         conn = (Connection) getServletContext().getAttribute("conn");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        try {
//
//
//            String sql = "select * from usertable where username = ? and password = ?"; // 生成一条sql语句
//            // 创建一个Statment对象
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1,username);
//            ps.setString(2,password);
//
//
//            ResultSet rs = ps.executeQuery();
//
//
//            if (rs.next()) {
////                pw.write("<h1>Login Success!!!</h1>");
////                pw.write("<h1>Welcome,"+username+"</h1>");
//
//                request.setAttribute("username",rs.getString("username"));
//                request.setAttribute("password",rs.getString("password"));
//                request.setAttribute("email",rs.getString("email"));
//                request.setAttribute("gender",rs.getString("gender"));
//                request.setAttribute("date",rs.getString("birthDate"));
//
//                request.getRequestDispatcher("userInfo.jsp").forward(request, response);
//
//            }
//
//            else {
////                pw.write("<h1>Login Error！</h1>");
//
//                request.setAttribute("message","Username or Password Error !!!");
//                request.getRequestDispatcher("login.jsp").forward(request, response);
//            }
//
//
//
//        } catch (SQLException e) {
//
//            e.printStackTrace();
//        }


        String username = request.getParameter("username");
        String password = request.getParameter("password");


        UserDao userDao = new UserDao();
        try {
           User user =  userDao.findByUsernamePassword(conn,username,password);

           if(user != null)
           {
               request.setAttribute("user",user);
               request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
           }
           else{
               request.setAttribute("message","Username or Password Error !!!");
               request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }
}
