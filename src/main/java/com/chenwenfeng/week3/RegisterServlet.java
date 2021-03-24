package com.chenwenfeng.week3;



import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;



public class RegisterServlet extends HttpServlet {

    private String driver;
    private String username;
    private String password;
    private String url;
    @Override
    public void init(ServletConfig config) throws ServletException {
        driver = config.getInitParameter("driver");
        url = config.getInitParameter("url");
        username = config.getInitParameter("username");
        password = config.getInitParameter("password");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String user =request.getParameter("username");
        String pass= request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String date = request.getParameter("date");


        try {

            Class.forName(driver);
            // 建立数据库连接，获得连接对象conn
            Connection conn = DriverManager.getConnection(url, username, password);
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
            // 关闭数据库连接对象
            conn.close();

        } catch (SQLException | ClassNotFoundException e) {

            e.printStackTrace();
        }







        response.sendRedirect(request.getContextPath()+"/selectAll");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        doPost(request, response);
    }
}
