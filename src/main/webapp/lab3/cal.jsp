<%--
  Created by IntelliJ IDEA.
  User: Nice
  Date: 2021/6/15
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


    <form action="${pageContext.request.contextPath}/CalServlet" method="post" id="myForm">
        First Val:<input type="text" name="firstVal" value="${cookie.cFirstValue.value}" id="first"/>
        Enter a Name:<input type="text" name="name" value="${cookie.cName.value}" id="name"/><br/>
        Second Val:  <input type="text" name="secondVal" value="${cookie.cSecondValue.value}" id="second">
        Length:      <input type="text" value="${cookie.cLength.value}" id="length"><br/>
        Result:      <input type="text" value="${cookie.cResult.value}" id="result"><br/>
        <input type="hidden" value="" id="hidden" name="action">
        <button type="submit" value="Add" id="add">add</button>
        <button type="submit" value="Subtract" id="sub">Subtract</button>
        <button type="submit" value="Multiply" id="mul">Multiply</button>
        <button type="submit" value="Divide" id="div">Divide</button>
        <button type="submit" value="Compute Length" id="comp">Compute Length</button>
        <button type="button" value="Reset" id="reset">Reset</button>



    </form>
    <script src="../week2/static/jquery-3.4.1.js"></script>
    <script>

        // let first = document.getElementById("first");
        // let second = document.getElementById("second");
        //
        // function add() {
        //     if (isNaN(first.value)){
        //         alert("a");
        //     }
        //     if (isNaN(second.value)){
        //         alert("b");
        //     }
        //
        // }

        $('#add').click(function () {
            $("#hidden").attr("value","Add");
            if(checkFormNum()){
                $('#myForm').submit();
            }
        })
        $('#sub').click(function () {
            $('#hidden').attr("value","Subtract");
            if(checkFormNum()){
                $('#myForm').submit();
            }
        })
        $('#mul').click(function () {
            $('#hidden').attr("value","Multiply");
            if(checkFormNum()){
                $('#myForm').submit();
            }
        })
        $('#div').click(function () {
            $('#hidden').attr("value","Divide");
            if(checkFormNum()){
                $('#myForm').submit();
            }
        })
        $('#comp').click(function () {
            $('#hidden').attr("value","Compute Length");
            if(checkFormString()){
                $('#myForm').submit();
            }
        })
        $('#reset').click(function () {
            $('#first').attr("value","");
            $('#second').attr("value","");
            $('#name').attr("value","");
            $('#length').attr("value","");
            $('#result').attr("value","");
            $('#hidden').attr("value","");
        })

        function checkFormNum() {
            if (!checkNumber($('#first').val())){
                alert("First val is not a number");
                return false;
            }
            if (!checkNumber($('#second').val())){
                alert("Second val is not a number");
                return false;
            }
            return true;
        }

        function checkFormString() {
            if (checkString($('#name').val())){
                alert("Name is not valid");
                return false;
            }
            return true;
        }

        function checkNumber(theObj) {
            var reg = /^[0-9]+.?[0-9]*$/;
            return reg.test(theObj);
        }

        function checkString(str) {
            var reg=/\d/;
            return reg.test(str);
        }
    </script>

</body>
</html>
