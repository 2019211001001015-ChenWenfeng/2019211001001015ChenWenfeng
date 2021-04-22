<%--
  Created by IntelliJ IDEA.
  User: Nice
  Date: 2021/4/22
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.chenwenfeng.model.User" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../week2/static/bootstrap.css">
    <script src="../../week2/static/jquery-3.4.1.js"></script>
</head>
<body>
<h1>User  Update!</h1>

<%
    User user = (User)session.getAttribute("user");

%>

<form action="${pageContext.request.contextPath}/update" class="form-horizontal" style="margin-top: 80px" method="post" target="iframe">
    <input type="hidden" name="id" value="<%=user.getId()%>">

    <div class="form-group">
        <h2 class="col-sm-offset-5 col-sm-7">New User Registration!</h2>
    </div>
    <div class="form-group">
        <label for="username" class="col-sm-5 control-label"></label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="username" placeholder="Username" name="username" value="<%=user.getUsername()%>">
        </div>
        <span id="usernameError" style="color: red;display: none">username is  null！</span>
    </div>
    <div class="form-group">
        <label for="inputPassword3" class="col-sm-5 control-label"></label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="inputPassword3"  placeholder="Password" name="password" value="<%=user.getPassword()%>">
        </div>
        <span id="passwordError1" style="color: red;display: none">password is null！</span>
        <span id="passwordError2" style="color: red;display: none">length less than 8！</span>
    </div>
    <div class="form-group">
        <label for="inputPassword3" class="col-sm-5 control-label"></label>
        <div class="col-sm-3">
            <input type="email" class="form-control" id="Email" placeholder="Email" name="email" value="<%=user.getEmail()%>">
        </div>
        <span id="emailError" style="color: red;display: none">email is null！</span>
    </div>
    <div class="form-group">
        <label class="col-sm-5 control-label">
        </label>
        <div class="col-sm-7">
            <label class="radio-inline" style="font-weight: bold">Gender</label>
            <label class="radio-inline">
                <input type="radio" name="gender" id="man" value="Male" <%="Male".equals(user.getGender())?"checked":""%>> Male
            </label>
            <label class="radio-inline">
                <input type="radio" name="gender" id="woman" value="Female"<%="Female".equals(user.getGender())?"checked":""%>> Female
            </label>
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword3" class="col-sm-5 control-label"></label>
        <div class="col-sm-3">
            <input type="date" class="form-control" id="date" name="date" value="<%=user.getBirthDate()%>">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-5 col-sm-3">
            <input type="submit" class="btn btn-success" id="submit" value="Save Changes">
        </div>
    </div>


</form>
<script>
    function lose(){
        var submit = $('#submit');
        submit.attr("disabled","disabled");
        submit.removeClass();
        submit.addClass("btn btn-default");
    }

    function agree()
    {
        var submit = $('#submit');
        submit.removeAttr("disabled");
        submit.removeClass();
        submit.addClass("btn btn-success");
    }


    $('#username').blur(function () {
        if($('#username').val() === ''){
            $('#usernameError').css("display","block");
            lose();
        }
        else{
            $('#usernameError').css("display","none");
            agree();
        }
    })
    $('#inputPassword3').blur(function () {
        if($('#inputPassword3').val() === ''){
            $('#passwordError2').css("display","none");
            $('#passwordError1').css("display","block");
            lose();
        }else if($('#inputPassword3').val().length < 8){
            $('#passwordError1').css("display","none");
            $('#passwordError2').css("display","block");
            lose();
        }
        else{
            $('#passwordError2').css("display","none");
            agree();
        }
    })

    $('#Email').blur(function () {
        if($('#Email').val() === ''){
            $('#emailError').css("display","block");
            lose();
        }
        else{
            $('#emailError').css("display","none");
            agree();
        }
    })




</script>
</body>
</html>
<%@include file="footer.jsp"%>
