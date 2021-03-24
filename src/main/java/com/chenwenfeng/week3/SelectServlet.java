package com.chenwenfeng.week3;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


public class SelectServlet extends HttpServlet {
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

            String user,pass,email,gender,date;
        try {


            Class.forName(driver);
            // 建立数据库连接，获得连接对象conn
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "select * from usertable"; // 生成一条sql语句
            // 创建一个Statment对象

            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(sql);

            PrintWriter pw = response.getWriter();
            pw.write("<table border="+1+">");
            pw.write("<tr>");
            pw.write("<td>username</td>");
            pw.write("<td>password</td>");
            pw.write("<td>email</td>");
            pw.write("<td>gender</td>");
            pw.write("<td>birthDate</td>");
            pw.write("</tr>");
            while (rs.next()) {
                // 获得id值
                user = rs.getString("username");
                pass = rs.getString("password");
                email = rs.getString("email");
                gender = rs.getString("gender");
                date = rs.getString("birthDate");




               pw.write("<tr>");
               pw.write("<td>"+user+"</td>");
               pw.write("<td>"+pass+"</td>");
               pw.write("<td>"+email+"</td>");
               pw.write("<td>"+gender+"</td>");
               pw.write("<td>"+date+"</td>");

                pw.write("</tr>");


            }
            pw.write("</table>");






            // 关闭数据库连接对象
            conn.close();

        } catch (SQLException | ClassNotFoundException e) {

            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
    }
}
