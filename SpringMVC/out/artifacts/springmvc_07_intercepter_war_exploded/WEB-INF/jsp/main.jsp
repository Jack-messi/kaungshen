<%--
  Created by IntelliJ IDEA.
  User: Heaven
  Date: 2021/8/12
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>首页</h1>
    <span>${username}</span>
<p>
    <a href="${pageContext.request.contextPath}/user/gouOut">注销</a>
</p>
</body>
</html>
