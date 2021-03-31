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
<form action="${pageContext.request.contextPath}/login" method="post">
    username:<input type="text" name="username"><br/>
    password:<input type="password" name="password"><br/>
    <input type="submit" value="Login">
</form>
<%@include file="footer.jsp"%>
</body>
</html>
