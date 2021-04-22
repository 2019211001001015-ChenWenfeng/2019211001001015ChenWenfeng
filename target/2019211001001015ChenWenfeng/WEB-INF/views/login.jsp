<%--
  Created by IntelliJ IDEA.
  User: Nice
  Date: 2021/3/31
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>
<h1>Login</h1>

<%
    if(!(request.getAttribute("message")==null))
    {
        out.print("<h3>"+request.getAttribute("message")+"<h3>");
    }
%>

<%
    Cookie[] cookies = request.getCookies();
    String username="",password="",rememberMe="";
    if(cookies != null)
    {
        for (Cookie cookie:cookies) {
            if(cookie.getName().equals("cUsername"))
            {
                username = cookie.getValue();
            }
            if(cookie.getName().equals("cPassword"))
            {
                password = cookie.getValue();
            }
            if(cookie.getName().equals("cRememberMe"))
            {
                rememberMe = cookie.getValue();
            }
        }
    }


%>
<form action="${pageContext.request.contextPath}/login" method="post">
    username:<input type="text" name="username" value="<%=username%>"><br/>
    password:<input type="password" name="password" value="<%=password%>"><br/>
    <input type="checkbox" value="1" <%=rememberMe.equals("1")?"checked":""%>checked/>RememberMe<br/>
    <input type="submit" value="Login">
</form>
<%@include file="footer.jsp"%>
</body>
</html>
