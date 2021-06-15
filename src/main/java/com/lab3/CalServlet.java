package com.lab3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalServlet",value = "/CalServlet")
public class CalServlet extends HttpServlet {

    private int add(int firstVal,int secondVal)
    {
        return firstVal+secondVal;
    }
    private int sub(int firstVal,int secondVal)
    {
        return firstVal-secondVal;
    }
    private int mul(int firstVal,int secondVal)
    {
        return firstVal*secondVal;
    }
    private int div(int firstVal,int secondVal)
    {
        return firstVal/secondVal;
    }
    private int compute(String value)
    {
        return value.length();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int firstVal = Integer.parseInt(request.getParameter("firstVal"));
            int secondVal = Integer.parseInt(request.getParameter("secondVal"));
            String name = request.getParameter("name");
            String action = request.getParameter("action");


            int result = 0;
            if(action.equals("Add") || action.equals("Subtract")||action.equals("Multiply")||action.equals("Divide"))
            {
                if(action.equals("Add"))
                {
                    result = add(firstVal,secondVal);
                }else  if(action.equals("Subtract"))
                {
                    result = sub(firstVal,secondVal);
                }else  if(action.equals("Multiply"))
                {
                    result = mul(firstVal,secondVal);
                }else
                {
                    result = div(firstVal,secondVal);
                }
                Cookie cFirstValue = new Cookie("cFirstValue",String.valueOf(firstVal));
                Cookie cSecondValue = new Cookie("cSecondValue",String.valueOf(secondVal));
                Cookie cResult = new Cookie("cResult",String.valueOf(result));
                response.addCookie(cFirstValue);
                response.addCookie(cSecondValue);
                response.addCookie(cResult);

            }else if(action.equals("Compute Length"))
            {
                int len = compute(name);
                Cookie cLength = new Cookie("cLength",String.valueOf(len));
                Cookie cName = new Cookie("cName",name);
                response.addCookie(cLength);
                response.addCookie(cName);
            }
            System.out.println(result);
            response.sendRedirect("lab3/cal.jsp");




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
