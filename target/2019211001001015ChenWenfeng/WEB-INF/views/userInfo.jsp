<%@ page import="com.chenwenfeng.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Nice
  Date: 2021/4/7
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>User Info</h1>
<%
    User user = (User) session.getAttribute("user");
%>
<table>
    <tr><td>Username:</td><td><%=user.getUsername()%></td></tr>
    <tr><td>Password:</td><td><%=user.getPassword()%></td></tr>
    <tr><td>Email:</td><td><%=user.getEmail()%></td></tr>
    <tr><td>Gender:</td><td><%=user.getGender()%></td></tr>
    <tr><td>Date:</td><td><%=user.getBirthDate()%></td></tr>
</table>
<form action="update" method="get">

    <input type="submit" value="Update">
</form>

</body>
</html>
<%@include file="footer.jsp"%>
