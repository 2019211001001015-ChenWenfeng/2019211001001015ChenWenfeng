package com.chenwenfeng.week3;





import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {


    Connection conn = null;
    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 建立数据库连接，获得连接对象conn
        try {
            conn = DriverManager.getConnection(url, username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String user =request.getParameter("username");
        String pass= request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String date = request.getParameter("date");


        try {


            String sql = "insert into usertable values (?,?,?,?,?)"; // 生成一条sql语句
            // 创建一个Statment对象
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user);
            ps.setString(2,pass);
            ps.setString(3,email);
            ps.setString(4,gender);
            ps.setString(5,date);





            // 执行sql语句
            ps.executeUpdate();


        } catch (SQLException e) {

            e.printStackTrace();
        }







        response.sendRedirect("/2019211001001015ChenWenfeng/login.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        doPost(request, response);
    }

   
}
