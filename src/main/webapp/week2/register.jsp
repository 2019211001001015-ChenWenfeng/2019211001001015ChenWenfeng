<%--
  Created by IntelliJ IDEA.
  User: Nice
  Date: 2021/3/10
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="static/bootstrap.css">
    <script src="static/jquery-3.4.1.js"></script>


    
</head>

<body>
<form action="#" class="form-horizontal" style="margin-top: 80px" method="post" target="iframe">
    <div class="form-group">
        <h2 class="col-sm-offset-5 col-sm-7">New User Registration!</h2>
    </div>
    <div class="form-group">
        <label for="username" class="col-sm-5 control-label"></label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="username" placeholder="Username">
        </div>
        <span id="usernameError" style="color: red;display: none">username is  null！</span>
    </div>
    <div class="form-group">
        <label for="inputPassword3" class="col-sm-5 control-label"></label>
        <div class="col-sm-3">
            <input type="password" class="form-control" id="inputPassword3"  placeholder="Password" name="password">
        </div>
        <span id="passwordError1" style="color: red;display: none">password is null！</span>
        <span id="passwordError2" style="color: red;display: none">length less than 8！</span>
    </div>
    <div class="form-group">
        <label for="inputPassword3" class="col-sm-5 control-label"></label>
        <div class="col-sm-3">
            <input type="email" class="form-control" id="Email" placeholder="Email" name="email">
        </div>
        <span id="emailError" style="color: red;display: none">email is null！</span>
    </div>
    <div class="form-group">
        <label class="col-sm-5 control-label">
        </label>
        <div class="col-sm-7">
            <label class="radio-inline" style="font-weight: bold">Gender</label>
            <label class="radio-inline">
               <input type="radio" name="inlineRadioOptions" id="man" > Male
            </label>
            <label class="radio-inline">
                <input type="radio" name="inlineRadioOptions" id="woman"> Female
            </label>
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword3" class="col-sm-5 control-label"></label>
        <div class="col-sm-3">
            <input type="date" class="form-control" id="date" >
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-5 col-sm-3">
            <input type="submit" class="btn btn-success" id="submit" value="register" disabled="disabled">
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
