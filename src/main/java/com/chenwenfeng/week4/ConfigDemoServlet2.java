package com.chenwenfeng.week4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConfigDemoServlet2",value = "/conig", initParams = {
        @WebInitParam(name = "name", value = "Chen Wenfeng"),
        @WebInitParam(name = "studentid",value = "2019211001001015")
})
public class ConfigDemoServlet2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = getServletConfig().getInitParameter("name");
        String studentid = getServletConfig().getInitParameter("studentid");

        PrintWriter pw = response.getWriter();
        pw.write("<h1>name:"+name+"</h1>");
        pw.write("<h1>studentid:"+studentid+"</h1>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}
