<%@ page import="com.lab2.Login" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/15/2021
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>validate</title>
</head>
<body>
<%--Todo 1: Use <jsp:useBean> to create a Login bean instance in request scope --%>
    <jsp:useBean id="login" class="com.lab2.Login" scope="request"></jsp:useBean>

    <%--Todo 2: Use <jsp:setProperty> to set  beans' property username and password--%>

    <jsp:setProperty name="login" property="username"/>
    <jsp:setProperty name="login" property="password"/>
<%
   //todo 3: use if check username is admin and ppassword is admin
    if(login.getUsername().equals("admin") && login.getPassword().equals("admin"))
    {
        Login login1 = new Login();
        login1.setUsername("admin");
        login1.setPassword("admin");

        HttpSession session1 = request.getSession();
        session1.setAttribute("user",login1);

%>
    <jsp:forward page="welcome.jsp"/>

    <%--todo 4: use jsp:forward to welcome.jsp page--%>


    <%--todo 5: else part{ --%>

<%
}
    else {
// todo 6: print username or password error message
    out.print("username or password error message");




%>
    <%--todo 7: use jsp:include login.jsp page --%>
    <jsp:include page="login.jsp"/>

    <%--todo 8: close else --%>
<%
    }
%>



</body>
</html>