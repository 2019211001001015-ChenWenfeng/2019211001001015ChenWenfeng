<html>
<body>
<%@include file="header.jsp"%>
This is my JSP page.<br/>
<h2>Hello World!</h2>
<form  action="${pageContext.request.contextPath}/search" method="post">
    <input type="text" name="txt" size="30"/>

    <select name="search">
        <option value="baidu">baidu</option>
        <option value="bing">bing</option>
        <option value="google">google</option>
    </select>

    <input type="submit" value="search">
</form>
<%@include file="footer.jsp"%>
</body>
</html>
