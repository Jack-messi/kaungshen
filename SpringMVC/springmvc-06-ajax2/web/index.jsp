<%--
  Created by IntelliJ IDEA.
  User: Heaven
  Date: 2021/8/11
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.5.1.min.js"></script>

    </script>

    <script>
        function a() {
            $.post({
                url: "${pageContext.request.contextPath}/a1",
                data: {"name": $("#username").val()},
                success: function (data) {
                    console.log("data = "+data);
                    console.log("status = "+status);
                },
                error: function (){
                    alert("error");
                }
            })
        }
    </script>
</head>
<body>

<input type="text" id="username" onblur="a()">
</body>
</html>
