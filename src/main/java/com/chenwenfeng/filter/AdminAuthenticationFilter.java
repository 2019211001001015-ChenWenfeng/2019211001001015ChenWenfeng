package com.chenwenfeng.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/*")
public class AdminAuthenticationFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        HttpSession session = httpRequest.getSession(false);

        boolean isLoggedIn = (session != null && session.getAttribute("userList")!=null);
        String loginURI = httpRequest.getContextPath()+"/admin/login";
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
        boolean isLoginPage = httpRequest.getRequestURI().endsWith("login");

        if(isLoggedIn && (isLoginRequest || isLoginPage))
        {
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("/admin/home");
            dispatcher.forward(servletRequest,servletResponse);

        }else  if(isLoggedIn || isLoginRequest)
        {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else
        {
            httpResponse.sendRedirect(httpRequest.getContextPath()+"/admin/login");
        }
    }

    @Override
    public void destroy() {

    }
}
