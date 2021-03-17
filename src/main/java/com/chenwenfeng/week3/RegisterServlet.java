package com.chenwenfeng.week3;

import com.sun.deploy.nativesandbox.NativeSandboxOutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password= request.getParameter("password");
        String email = request.getParameter("email");
        String gender= request.getParameter("sex");
        String date =  request.getParameter("date");

        PrintWriter pw = response.getWriter();
        pw.write("<h1>username:"+username+"</h1>");
        pw.write("<h1>password:"+password+"</h1>");
        pw.write("<h1>email:"+email+"</h1>");
        pw.write("<h1>gender:"+gender+"</h1>");
        pw.write("<h1>birthDate:"+date+"</h1>");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        doPost(request, response);
    }
}
